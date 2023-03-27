package com.ifs.app.model;


import com.ifs.app.dto.TorneioDTO;
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
@Table(name="tor_torneio",schema="public")
public class TorneioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int torNrId;

    @Column( nullable = false, length = 100)
    private String torTxNome;

    public TorneioDTO toTorneio() {
        return TorneioDTO.builder()
                .torNrId(torNrId)
                .torTxNome(torTxNome)
                .build();
    }


}

