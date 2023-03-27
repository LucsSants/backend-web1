package com.ifs.app.dto;

import com.ifs.app.model.CategoriaModel;
import com.ifs.app.model.TorneioModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private int catNrId;
    private TorneioModel torneio;
    private String catTxNome;

    public CategoriaModel toCategoria() {
        return CategoriaModel.builder()
                .catNrId(catNrId)
                .torneio(torneio)
                .catTxNome(catTxNome)
                .build();
    }

}
