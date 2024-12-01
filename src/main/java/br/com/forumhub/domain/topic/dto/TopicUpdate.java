package br.com.forumhub.domain.topic.dto;

public record TopicUpdate(
        String title,
        String message,
        String status,
        Long author,
        Long course
)
{}