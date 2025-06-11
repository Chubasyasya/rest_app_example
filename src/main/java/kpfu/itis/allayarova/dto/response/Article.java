package kpfu.itis.allayarova.dto.response;

public record Article(
        String title,
        String description,
        String url,
        String publishedAt
) {}