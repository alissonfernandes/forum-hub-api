package br.com.forumhub.domain.topic.repository;

import br.com.forumhub.domain.topic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
