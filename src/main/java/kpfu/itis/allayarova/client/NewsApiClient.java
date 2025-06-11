package kpfu.itis.allayarova.client;

import kpfu.itis.allayarova.client.properties.NewsApiProperties;
import kpfu.itis.allayarova.dto.response.NewResponse;
import kpfu.itis.allayarova.dto.response.NewsApiResponse;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Component
@Data
public class NewsApiClient {

    private final NewsApiProperties properties;
    private final WebClient webClient;

    public NewsApiClient(NewsApiProperties properties, WebClient.Builder webClientBuilder) {
        this.properties = properties;
        this.webClient = webClientBuilder
                .baseUrl(properties.getNewServiceUrl())
                .build();
    }


    public List<NewResponse> getTopHeadlines() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/top-headlines")
                        .queryParam("country", properties.getCountry())
                        .queryParam("apiKey", properties.getApiKey())
                        .build())
                .retrieve()
                .bodyToMono(NewsApiResponse.class)
                .map(newsApiResponse -> newsApiResponse.articles().stream()
                        .map(article -> new NewResponse(
                                null,
                                article.title(),
                                article.description(),
                                article.url(),
                                article.publishedAt()
                        )).toList())
                .block();
    }
}