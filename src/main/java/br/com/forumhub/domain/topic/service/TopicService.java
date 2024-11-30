package br.com.forumhub.domain.topic.service;

import br.com.forumhub.domain.exception.NotFoundException;
import br.com.forumhub.domain.topic.dto.NewTopic;
import br.com.forumhub.domain.topic.dto.TopicData;
import br.com.forumhub.domain.topic.model.Topic;
import br.com.forumhub.domain.topic.repository.CourseRepository;
import br.com.forumhub.domain.topic.repository.TopicRepository;
import br.com.forumhub.domain.topic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository authorRepository;

    @Autowired
    private CourseRepository courseRepository;

    public TopicData createNew(NewTopic newTopic) {

        if (!authorRepository.existsById(newTopic.author()))
            throw new NotFoundException("author not found with id = " + newTopic.author());

        if (!courseRepository.existsById(newTopic.course()))
            throw new NotFoundException("course not found with id = "+ newTopic.course());

        if (topicRepository.countTopicsWith(newTopic.title(), newTopic.message()) != 0)
            throw new RuntimeException("topic exists");

        var author = authorRepository.getReferenceById(newTopic.author());
        var course = courseRepository.getReferenceById(newTopic.course());

        var topicToSave = new Topic(null, newTopic.title(), newTopic.message(), LocalDateTime.now(), "Aberto", author, course);

        var ts = topicRepository.save(topicToSave);
        return new TopicData(ts.getId(), ts.getTitle(), ts.getMessage(), ts.getCreateDate(), ts.getStatus(), ts.getAuthor().getId(), ts.getCourse().getId());
    }
}
