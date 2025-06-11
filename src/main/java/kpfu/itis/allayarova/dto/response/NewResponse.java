package kpfu.itis.allayarova.dto.response;

public record NewResponse(
        Long id,

        String title,
        String description,
        String url,
        String publishedAt) {
}

