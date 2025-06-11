package kpfu.itis.allayarova.dto.request;

public record NewRequest(
        Long id,

        String title,
        String description,
        String url,
        String publishedAt) {
}
