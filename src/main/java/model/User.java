package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.stream.events.Comment;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor(force = true) @EqualsAndHashCode(of = {"email"})
@ToString(callSuper = true, of = {"name"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_moderator", nullable = false)
    private boolean isModerator;

    @NotNull
    @Column(name = "reg_time", nullable = false)
    private Instant regTime;

    @NotBlank
    @Size(max=255)
    @Column(nullable = false)
    private String name;

    @NaturalId(mutable = true) @Email
    @NotBlank @Size(max=255)
    @Column(nullable = false)
    private String email;

    @NotBlank @Size(max=255)
    @Column(nullable = false)
    private String password;

    @Size(max=255)
    private String code;


    @Column(columnDefinition = "TEXT")
    private String photo;

    @NotNull
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Post> posts = new HashSet<>();

    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Comment> comments = new HashSet<>();

    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Vote> votes = new HashSet<>();
}

