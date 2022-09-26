package main.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "post_comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name="parent_id", referencedColumnName = "id")
    private Integer parentId;

    @NotNull
    @OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
    private final List<Comment> childComments = new ArrayList<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @NotNull
    @Column(nullable = false)
    private Instant time = Instant.now();

    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
}
