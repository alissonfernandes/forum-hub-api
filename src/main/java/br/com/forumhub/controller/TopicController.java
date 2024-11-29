package br.com.forumhub.controller;

import br.com.forumhub.domain.topic.dto.NewTopic;
import br.com.forumhub.domain.topic.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewTopic newTopic) {
        return ResponseEntity.ok(topicService.createNew(newTopic));
    }
}
