package br.com.project.futbarproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(schema = "futbar", name = "membership")
@Getter
@Setter
public class Membership implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true)
    public Long id;

    @Column(name = "name", length = 60)
    @NotNull(message = "O nome da filiação é obrigatório, por favor preencher o campo.")
    @NotBlank(message = "O nome da filiação é obrigatório, por favor preencher o campo.")
    @Size.List({
            @Size(min = 8, message = "O nome da filiação deve conter no máximo {min} caracteres."),
            @Size(max = 60, message = "O nome da filiação deve conter no máximo {max} caracteres.")
    })
    public String name;

}
