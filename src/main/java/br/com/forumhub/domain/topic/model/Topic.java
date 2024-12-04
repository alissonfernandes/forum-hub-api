package br.com.forumhub.domain.topic.model;

import br.com.forumhub.domain.topic.dto.NewTopic;
import br.com.forumhub.domain.topic.dto.TopicUpdate;
import br.com.forumhub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topic")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @Setter
    private User author;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @Setter
    private Course course;

    public Topic(NewTopic newTopic) {
        title = newTopic.title();
        message = newTopic.message();
    }

    public void update(TopicUpdate t) {
        if (t.title() != null) title = t.title();
        if (t.message() != null) message = t.message();
        if (t.status() != null) status = t.status();
    }
}
