package main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status", columnDefinition = "enum('NEW', 'ACCEPTED', 'DECLINED') default " +
            "'NEW'", nullable = false)
    private ModerationStatus moderationStatus;


    @Column(name = "moderator_id")
    private int moderatorId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName="id")
    private User author;

    @Column(nullable = false)
    private Instant time;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(name = "view_count", nullable = false)
    private int viewCount;

    //
    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="id"))
    private final Set<Tag> tags = new HashSet<>();

    @NotNull
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, orphanRemoval = true)
    private final List<Vote> votes = new ArrayList<>();

    @NotNull
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, orphanRemoval = true)
    private final List<Comment> comments = new ArrayList<>();

    public void addTag(@NotNull Tag tag) {
        tags.add(tag);
    }

    public void updateViewCount() {
        this.viewCount++;
    }
}
