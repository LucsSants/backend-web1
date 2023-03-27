package com.ifs.app.dto;

import com.ifs.app.model.CategoriaModel;
import com.ifs.app.model.InscricaoModel;
import com.ifs.app.model.TorneioModel;
import com.ifs.app.model.UsuarioModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InscricaoDTO {
    private int insNrId;

    private CategoriaModel categoria;

    private UsuarioModel usuarioUm;

    private UsuarioModel usuarioDois;

    public InscricaoModel toInscricao() {
        return InscricaoModel.builder()
                .insNrId(insNrId)
                .categoria(categoria)
                .usuarioUm(usuarioUm)
                .usuarioDois(usuarioDois)
                .build();
    }
}
