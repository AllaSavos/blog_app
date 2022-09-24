package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "votes")
@Data
@NoArgsConstructor(force = true)
public class Vote {
    public Vote(@NotNull User user, @NotNull Post post) {
        this.user = user;
        this.post = post;
    }

    public Vote(@NotNull User user, @NotNull Post post, @NotNull Instant time) {
        this(user, post);
        this.time = time;
    }

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @NotNull @Column(nullable = false)
    private Instant time = Instant.now();

    @Column(nullable = false)
    private byte value;

    public void like() {
        this.value = 1;
    }

    public void dislike() {
        this.value = -1;
    }
}
