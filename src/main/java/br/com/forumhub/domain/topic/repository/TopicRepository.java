package br.com.forumhub.domain.topic.repository;

import br.com.forumhub.domain.topic.model.Course;
import br.com.forumhub.domain.topic.model.Topic;
import br.com.forumhub.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t.author FROM Topic t JOIN t.author a WHERE a.id = :idAuthor")
    User getAuthorById(Long idAuthor);

    @Query("SELECT t.course FROM Topic t JOIN t.course c WHERE c.id = :idCourse")
    Course getCourseById(Long idCourse);

    @Query("SELECT COUNT(*) FROM Topic t WHERE t.title ILIKE :title AND t.message ILIKE :menssage")
    Integer countTopicsWith(String title, String menssage);
}
