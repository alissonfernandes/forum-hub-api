package br.com.forumhub.domain.topic.model;

import br.com.forumhub.domain.topic.dto.NewTopic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private User author;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Topic(NewTopic newTopic) {
        title = newTopic.title();
        message = newTopic.message();
    }
}
