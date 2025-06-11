package kpfu.itis.allayarova.client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "news")
@Data
public class NewsApiProperties {
    private String apiKey;
    private String country;
    private String newServiceUrl;
}
