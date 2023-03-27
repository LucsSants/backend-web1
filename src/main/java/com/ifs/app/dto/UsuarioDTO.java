package com.ifs.app.dto;


import com.ifs.app.model.UsuarioModel;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private int usuNrId;
    @NotBlank(message = "Nome é obrigatório!")
    private String usuTxNome;
    @NotBlank(message = "Login é obrigatório!")
    @Length(min = 4, message = "Login Deve ter pelo menos 4 Caracteres")
    @Length(max = 20, message = "Login Deve ter no máximo 20 Caracteres")
    private String usuTxLogin ;
    @NotBlank(message = "Senha é obrigatório!")
    @Length(min = 4, message = "Senha Deve ter pelo menos 4 Caracteres")
    private String usuTxSenha;

    private LocalDateTime usuDtCadstro;

    public UsuarioModel toUsuario() {
        return UsuarioModel.builder()
                .usuNrId(usuNrId)
                .usuTxNome(usuTxNome)
                .usuTxLogin(usuTxLogin)
                .usuTxSenha(usuTxSenha)
                .usuDtCadstro(usuDtCadstro)
                .build();
    }

}
