package main.model;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_moderator", nullable = false)
    private boolean isModerator;

    @Column(name = "reg_time", nullable = false)
    private Instant regTime;

    @Column(nullable = false)
    private String name;

    @NaturalId
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Size(max=255)
    private String code;


    @Column(columnDefinition = "TEXT")
    private String photo;

    @NotNull
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, orphanRemoval = true)
    private final List<Post> posts = new ArrayList<>();

    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private final List<Comment> comments = new ArrayList<>();

    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private final List<Vote> votes = new ArrayList<>();
}

