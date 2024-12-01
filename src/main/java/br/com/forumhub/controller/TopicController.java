package br.com.forumhub.controller;

import br.com.forumhub.domain.topic.dto.NewTopic;
import br.com.forumhub.domain.topic.dto.TopicData;
import br.com.forumhub.domain.topic.dto.TopicUpdate;
import br.com.forumhub.domain.topic.repository.TopicRepository;
import br.com.forumhub.domain.topic.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewTopic newTopic) {
        return ResponseEntity.ok(topicService.createNew(newTopic));
    }

    @GetMapping
    public ResponseEntity listAll(@PageableDefault(size = 10, sort = {"createDate"}) Pageable pageable) {
        var page = topicRepository.findAll(pageable).map(TopicData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.findById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long id, @RequestBody TopicUpdate update) {
        return ResponseEntity.ok(topicService.update(id, update));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        topicService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
