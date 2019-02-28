package curator.wechat.service;

import curator.wechat.dto.NormalMsg;
import curator.wechat.entity.GitConfig;
import curator.wechat.repository.GitConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WechatService {

    @Autowired
    private UserService userService;

    @Autowired
    private GitConfigRepository gitConfigRepository;

    @Transactional
    public void handler(NormalMsg normalMsg) {
        if (normalMsg.getContent().startsWith("add ")) {
            normalMsg.setContent(normalMsg.getContent().replaceFirst("add ", ""));
            userService.createOrEditGitInfo(normalMsg);
        } else if (normalMsg.getContent().equals("ls")) {
            Optional<GitConfig> gitConfig = gitConfigRepository.findByOpenId(normalMsg.getFromUserName());
            normalMsg.setContent(gitConfig.isPresent() ? gitConfig.get().getNickName() + ":" + gitConfig.get().getBranchName() : "ㄟ( ▔, ▔ )ㄏ");
        } else if (normalMsg.getContent().equals("rm")) {
            gitConfigRepository.deleteByOpenId(normalMsg.getFromUserName());
            normalMsg.setContent("( •̀ ω •́ )✧");
        } else {
            normalMsg.setContent("(╬▔皿▔)凸");
        }



    }

}
