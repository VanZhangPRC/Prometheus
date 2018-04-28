package kraken.basic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Deprecated
@Component
@ConfigurationProperties(prefix = "system")
@PropertySource(value = "classpath:config.properties")
public class SystemConfig {
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
