package curator.wechat.service;

import curator.wechat.dto.NormalMsg;
import curator.wechat.dto.UserInfo;
import curator.wechat.entity.GitConfig;
import curator.wechat.entity.WechatUrl;
import curator.wechat.repository.GitConfigRepository;
import curator.wechat.utils.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

//    @Autowired
//    private WechatConfigRepository wechatConfigRepository;

    @Autowired
    private GitConfigRepository gitConfigRepository;

    @Value(value = "${curator.wechat.appid}")
    private String appId;

    @Value(value = "${curator.wechat.appSecret}")
    private String appSecret;


    public void createOrEditGitInfo(NormalMsg normalMsg) {

        String content = normalMsg.getContent();

        String openid = normalMsg.getFromUserName();
        GitConfig gitConfig;
        Optional<GitConfig> gitConfigOptional = gitConfigRepository.findByOpenId(openid);
        gitConfig = gitConfigOptional.orElse(createNewConfig(openid));
        gitConfig.setBranchName(content);
        gitConfigRepository.save(gitConfig);
        normalMsg.setContent("[OK]");
    }

    // TODO 还要获取 access_token 才能拿到用户信息。。。。。
    private GitConfig createNewConfig(String openid) {
        String url = WechatUrl.getUserInfo(WechatUtil.getAccessToken(), openid);
        UserInfo userInfo = WechatUtil.getUserInfo(url);

        GitConfig gitConfig = new GitConfig();
        gitConfig.setOpenId(openid);
        gitConfig.setNickName(userInfo.getNickname());

        return gitConfig;
    }

}
