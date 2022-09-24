package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor(force = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "moderation_status", length = 10, nullable = false)
    private ModerationStatus moderationStatus = ModerationStatus.NEW;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "moderator_id", referencedColumnName="id")
    private User moderatedBy;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName="id")
    private User author;

    @NotNull
    @Column(nullable = false)
    private Instant time;

    @NotBlank
    @Size(max=255)
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(name = "view_count", nullable = false)
    private int viewCount;

    //
    @NotNull
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="id"))
    @LazyCollection(LazyCollectionOption.EXTRA)
    private final Set<Tag> tags = new HashSet<>();

    @NotNull
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private final Set<Vote> votes = new HashSet<>();

    @NotNull
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private final Set<Comment> comments = new HashSet<>();

    public void addTag(@NotNull Tag tag) {
        tags.add(tag);
    }

    public void updateViewCount() {
        this.viewCount++;
    }
}
