package curator.wechat.repository;

import curator.wechat.entity.GitConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface GitConfigRepository extends JpaRepository<GitConfig, Integer>, JpaSpecificationExecutor<GitConfig> {
    Optional<GitConfig> findByOpenId(String openId);
    List<GitConfig> listByOpenId(String openId);
    void deleteByOpenId(String openid);
}
