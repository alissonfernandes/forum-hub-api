package br.com.forumhub.domain.topic.dto;

import br.com.forumhub.domain.topic.model.Topic;

import java.time.LocalDateTime;

public record TopicData(Long id, String title, String message, LocalDateTime date, String status, Long author, Long course) {

    public TopicData(Topic t) {
        this(
            t.getId(),
            t.getTitle(),
            t.getMessage(),
            t.getCreateDate(),
            t.getStatus(),
            t.getAuthor().getId(),
            t.getCourse().getId()
        );
    }
}
