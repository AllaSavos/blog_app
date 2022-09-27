package main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @Column(nullable = false)
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
