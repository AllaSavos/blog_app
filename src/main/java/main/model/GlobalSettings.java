package main.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "global_settings")
@Data
@NoArgsConstructor(force = true) @EqualsAndHashCode()
public class GlobalSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NaturalId
    @NotNull
    @Column(length = 30, nullable = false)
    private String code;

    @NotBlank
    @Size(max=255)
    @Column(nullable = false)
    private String name;


    @NotNull
    @Column(length = 5, nullable = false)
    private String value;
}
