package com.ifs.app.model;


import com.ifs.app.dto.UsuarioDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usu_usuario",schema="public")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int usuNrId;

    @Column( nullable = false, length = 100)
    private String usuTxNome;

    @Column( nullable = false, length = 20)
    private String usuTxLogin;

    @Column( nullable = false, length = 999)
    private String usuTxSenha;

    @Column( nullable = false)
    private LocalDateTime usuDtCadstro;



    public UsuarioDTO toUsuario() {
        return UsuarioDTO.builder()
                .usuNrId(usuNrId)
                .usuTxNome(usuTxNome)
                .usuTxLogin(usuTxLogin)
                .usuDtCadstro(usuDtCadstro)
                .build();
    }

}
