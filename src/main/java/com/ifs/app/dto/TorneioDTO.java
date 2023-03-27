package com.ifs.app.dto;

import com.ifs.app.model.TorneioModel;
import com.ifs.app.model.UsuarioModel;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TorneioDTO implements Serializable {

    private int torNrId;

    private String torTxNome;


    public TorneioModel toTorneio() {
        return TorneioModel.builder()
                .torNrId(torNrId)
                .torTxNome(torTxNome)
                .build();
    }


}
