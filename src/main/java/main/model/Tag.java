package main.model;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NaturalId
    @Column(nullable = false)
    private String name;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private final Set<Post> posts = new HashSet<>();

}