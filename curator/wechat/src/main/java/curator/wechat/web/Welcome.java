package curator.wechat.web;

import curator.wechat.dto.NormalMsg;
import curator.wechat.service.WechatService;
import curator.wechat.utils.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/wechat")
public class Welcome {

    @Autowired
    private WechatService wechatService;

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
            String newSignature = WechatUtil.byteArrayToHexString(md.digest(sb.toString().getBytes()));
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

        NormalMsg normalMsg = WechatUtil.getMsgFromUserInfo(msg);

        // TODO handle content
        wechatService.handler(normalMsg);

        String user = normalMsg.getFromUserName();
        normalMsg.setFromUserName(normalMsg.getToUserName());
        normalMsg.setToUserName(user);

        try {
            response.getOutputStream().write(WechatUtil.createSendMsg(normalMsg).getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
