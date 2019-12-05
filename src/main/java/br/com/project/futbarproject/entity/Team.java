package br.com.project.futbarproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(schema = "futbar", name = "team")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true)
    public Long id;

    @Column(name = "name", length = 60, unique = true)
    @NotNull(message = "Nome do time é obrigatório, por favor preencher o campo.")
    @NotBlank(message = "Nome do time é obrigatório, por favor preencher o campo.")
    @Size.List({
            @Size(min = 3, message = "O campo nome deve ter no minímo {min} caracteres."),
            @Size(max = 60, message = "O campo nome deve ter mo máximo {max} caracteres.")
    })
    public String name;

    @Column(name = "initials", length = 3)
    @Size(max = 3, message = "A sigla do time deve conter no máximo 3 caracteres.")
    @NotNull(message = "Sigla do time é obrigatório, por favor preencher o campo.")
    @NotBlank(message = "Sigla do time é obrigatório, por favor preencher o campo.")
    public String initials;

    @Column(name = "membership_id", length = 3)
    @NotNull(message = "Filiação do time é obrigatório, por favor selecionar o campo.")
    public Long membership_id;

    @Column(name = "equipment_id", length = 3)
    public Long equipment_id;

    @Column(name = "construction_id", length = 3)
    public Long construction_id;

    @Column(name = "region_id", length = 3)
    public Long region_id;




}
