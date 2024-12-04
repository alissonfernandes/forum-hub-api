package br.com.forumhub.domain.topic.service;

import br.com.forumhub.domain.exception.ExistingTopicException;
import br.com.forumhub.domain.exception.NotExistsException;
import br.com.forumhub.domain.exception.NotFoundException;
import br.com.forumhub.domain.topic.dto.NewTopic;
import br.com.forumhub.domain.topic.dto.TopicData;
import br.com.forumhub.domain.topic.dto.TopicUpdate;
import br.com.forumhub.domain.topic.model.Topic;
import br.com.forumhub.domain.topic.repository.CourseRepository;
import br.com.forumhub.domain.topic.repository.TopicRepository;
import br.com.forumhub.domain.user.UserRepository;
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

        verifyExistsAuthor(newTopic.author());
        verifyExistsCourse(newTopic.course());

        if (topicRepository.countTopicsWith(newTopic.title(), newTopic.message()) != 0)
            throw new ExistingTopicException("topic exists with title: '" + newTopic.title() + "' and message: '" + newTopic.message() + "'");//RuntimeException("topic exists");

        var author = authorRepository.getReferenceById(newTopic.author());
        var course = courseRepository.getReferenceById(newTopic.course());

        var topicToSave = new Topic(null, newTopic.title(), newTopic.message(), LocalDateTime.now(), "Aberto", author, course);

        var ts = topicRepository.save(topicToSave);
        return new TopicData(ts.getId(), ts.getTitle(), ts.getMessage(), ts.getCreateDate(), ts.getStatus(), ts.getAuthor().getId(), ts.getCourse().getId());
    }

    public TopicData findById(Long id) {

        verifyExistsTopic(id);

        var topic = topicRepository.getReferenceById(id);
        return new TopicData(topic);
    }

    public TopicData update(Long id, TopicUpdate updateTopic) {

        verifyExistsTopic(id);

        var topicToUpdate = topicRepository.getReferenceById(id);
        topicToUpdate.update(updateTopic);

        if (updateTopic.author() != null) {
            verifyExistsAuthor(updateTopic.author());
            var authorUpdate = authorRepository.getReferenceById(updateTopic.author());
            topicToUpdate.setAuthor(authorUpdate);
        }

        if (updateTopic.course() != null) {
            verifyExistsCourse(updateTopic.course());
            var courseUpdate = courseRepository.getReferenceById(updateTopic.course());
            topicToUpdate.setCourse(courseUpdate);
        }

        var topicSaved = topicRepository.save(topicToUpdate);
        return new TopicData(topicSaved);
    }

    public void delete(Long id) {
        verifyExistsTopic(id);
        topicRepository.deleteById(id);
    }

    private void verifyExistsTopic(Long id) {
        if (!topicRepository.existsById(id))
            throw new NotFoundException("topic not found with id = " + id);
    }

    private void verifyExistsAuthor(Long id) {
        if (!authorRepository.existsById(id))
            throw new NotExistsException("not exists author with id = " + id);//NotFoundException("author not found with id = " + id);
    }

    private void verifyExistsCourse(Long id) {
        if (!courseRepository.existsById(id))
            throw new NotExistsException("not exists course with id = " + id); //NotFoundException("course not found with id = " + id);
    }
}
