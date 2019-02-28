package curator.wechat.utils;

import curator.wechat.dto.AccessToken;
import curator.wechat.dto.NormalMsg;
import curator.wechat.dto.UserInfo;
import curator.wechat.entity.WechatUrl;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WechatUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    private static String accessToken = null;
    private static Integer expires = 0;
    private static Long lastTime = 0L;


    public static UserInfo getUserInfo(String url) {
        return restTemplate.getForObject(url, UserInfo.class);
    }

    public static String getAccessToken() {
        if (expires != null && System.currentTimeMillis() - lastTime <= expires)
            return accessToken;

        AccessToken token = restTemplate.getForObject(WechatUrl.getAccessToken(), AccessToken.class);
        accessToken = token.getAccessToken() == null ? "" : token.getAccessToken();
        expires = token.getExpiresIn() == null ? 0 : token.getExpiresIn();
        lastTime = System.currentTimeMillis();
        return accessToken;
    }


    public static NormalMsg getMsgFromUserInfo(String msg) {

        Map<String, Object> strMsg = WechatUtil.getMsg(msg);
        String content = strMsg.get("Content").toString();
        String fromUserName = strMsg.get("FromUserName").toString();
        String toUserName = strMsg.get("ToUserName").toString();
        String creatTime = strMsg.get("CreateTime").toString();

        NormalMsg normalMsg = new NormalMsg();
        normalMsg.setContent(content);
        normalMsg.setFromUserName(fromUserName);
        normalMsg.setToUserName(toUserName);
        normalMsg.setCreateTime(creatTime);
        return normalMsg;
    }


    public static String createSendMsg(NormalMsg msg) {
        String str = "<xml>" +
                String.format("<ToUserName><![CDATA[%s]]></ToUserName>", msg.getToUserName()) +
                String.format("<FromUserName><![CDATA[%s]]></FromUserName>", msg.getFromUserName()) +
                String.format("<CreateTime>%s</CreateTime>", msg.getCreateTime()) +
                "<MsgType><![CDATA[" + "text" + "]]></MsgType>" +
                String.format("<Content><![CDATA[%s]]></Content>", msg.getContent()) +
                "</xml>";
        return str;
    }

    public static String byteArrayToHexString(byte[] b) {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    public static Map<String, Object> getMsg(String msg) {
        Map<String, Object> strMap = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new ByteArrayInputStream(msg.getBytes("UTF-8")));
            Element root = document.getRootElement();
            Iterator iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element element = (Element) iterator.next();
                strMap.put(element.getName(), element.getData());
            }

        } catch (DocumentException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strMap;
    }
}
