package br.com.project.futbarproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "futbar", name = "user")
@Getter
@Setter
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true)
    public Long id;

    @Column(name = "name", length = 30)
    public String name;

    @Column(name = "email", length = 25, unique = true)
    @NotNull(message = "Email obrigatório, por favor preencher o campo.")
    @NotBlank(message = "Email obrigatório, por favor preencher o campo.")
    public String email;

    @Column(name = "password", length = 30)
    @NotNull(message = "Senha obrigatória, por favor preencher o campo.")
    @NotBlank(message = "Senha obrigatória, por favor preencher o campo.")
    /* Pelo menos uma letra maiúscula, (?=.*?[A-Z])
       Pelo menos uma letra minúscula, (?=.*?[a-z])
       Pelo menos um dígito, (?=.*?[0-9])
       Pelo menos um caractere especial, (?=.*?[#?!@$%^&*-])
       Comprimento mínimo de oito .{8,} */
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
            message = "A senha preenchida deve conter ao menos uma letra maiúscula e minúscula,"
                    + "um dígito, um caracter especial e no mínimo 8 caracteres.")
    public String password;

}
