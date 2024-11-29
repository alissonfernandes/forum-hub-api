package br.com.forumhub.domain.topic.service;

import br.com.forumhub.domain.topic.dto.NewTopic;
import br.com.forumhub.domain.topic.dto.TopicData;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicService {

    public TopicData createNew(NewTopic newTopic) {
        var topic = new TopicData(1L, newTopic.title(), newTopic.message(), LocalDateTime.now(), "Aberto", 1L, 2L);
        return topic;
    }
}
