package kpfu.itis.allayarova.dto.response;

import lombok.Data;

import java.util.List;

public record NewsApiResponse(
        String status,
        int totalResults,
        List<Article> articles
) {}