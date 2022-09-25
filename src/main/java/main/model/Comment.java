package main.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor(force = true) @EqualsAndHashCode(of = {"text", "time"})
@ToString(callSuper = true, of = {"text", "user", "time"})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName = "id")
    private Comment parentComment;

    @NotNull
    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Comment> childComments = new HashSet<>();

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false, updatable = false)
    private User user;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Post post;

    @NotNull
    @Column(nullable = false)
    private Instant time = Instant.now();

    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
}
