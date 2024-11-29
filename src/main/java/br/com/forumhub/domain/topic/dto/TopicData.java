package br.com.forumhub.domain.topic.dto;

import java.time.LocalDateTime;

public record TopicData(Long id, String title, String message, LocalDateTime date, String status, Long author, Long course) {
}
