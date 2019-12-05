package br.com.project.futbarproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(schema = "futbar", name = "equipment")
@Getter
@Setter
public class Equipment  implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true)
    public Long id;

    @Column(name = "description", length = 150)
    @NotBlank
    @NotNull
    public String description;

}
