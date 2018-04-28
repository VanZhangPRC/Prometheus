package kraken.hermes.web.controller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping(path = "/responder")
public class Responder {

    @RequestMapping(path = "/test")
    public Object test() {
        return true;
    }

    @RequestMapping(path = "/hello")
    public Object response(@RequestParam(name = "signature") String signature,
                           @RequestParam(name = "timestamp") String timestmap,
                           @RequestParam(name = "nonce") String nonce,
                           @RequestParam(name = "echostr") String echostr) {
        StringBuilder sb = new StringBuilder();

        String token = "Prometheus";
        List<String> keys = new LinkedList<String>();
        keys.add(token);
        keys.add(timestmap);
        keys.add(nonce);

        Collections.sort(keys);
        String[] keyStrs = new String[3];
        keys.toArray(keyStrs);

        for (String key : keyStrs) {
            sb.append(key);
        }


        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            String newSignature = byteArrayToHexString(md.digest(sb.toString().getBytes()));
            if (newSignature.equals(signature)) {
                return echostr;
            } else {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(path = "/hello", method = RequestMethod.POST)
    public void getMessage(@RequestBody String msg, HttpServletResponse response) {
        System.out.println(msg);
        Map<String, Object> strMsg = getMsg(msg);
        String content = strMsg.get("Content").toString();
        String fromUserName = strMsg.get("FromUserName").toString();
        String toUserName = strMsg.get("ToUserName").toString();
        String creatTime = strMsg.get("CreateTime").toString();

        String retContent;

        switch (content) {
            case "西安开发":
                retContent = "xian.zhfan.natapp1.cc/meterinstall/loginWechat.html";
                break;
            case "西安测试":
                retContent = "xiantest.zhfan.natapp1.cc/meterinstall/loginWechat.html";
                break;
            default:
                retContent = "(っ´Ι`)っ";
        }

        StringBuilder str = new StringBuilder();
        str.append("<xml>");
        str.append(String.format("<ToUserName><![CDATA[%s]]></ToUserName>", fromUserName));
        str.append(String.format("<FromUserName><![CDATA[%s]]></FromUserName>", toUserName));
        str.append(String.format("<CreateTime>%s</CreateTime>", creatTime));
        str.append("<MsgType><![CDATA[" + "text" + "]]></MsgType>");
        str.append(String.format("<Content><![CDATA[%s]]></Content>", retContent));
        str.append("</xml>");
        try {
            response.getOutputStream().write(str.toString().getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String byteArrayToHexString(byte[] b) {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    private Map<String, Object> getMsg(String msg) {
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
