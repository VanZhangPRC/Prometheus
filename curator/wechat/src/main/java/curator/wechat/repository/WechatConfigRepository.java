package curator.wechat.repository;

import curator.wechat.entity.WechatConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Deprecated
public interface WechatConfigRepository { //extends JpaRepository<WechatConfig, Integer>, JpaSpecificationExecutor<WechatConfig> {
    WechatConfig findByType(String type);
    boolean existsByType(String type);
}
