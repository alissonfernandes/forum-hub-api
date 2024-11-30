package br.com.forumhub.domain.topic.repository;

import br.com.forumhub.domain.topic.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
