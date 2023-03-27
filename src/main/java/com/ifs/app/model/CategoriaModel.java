package com.ifs.app.model;


import com.ifs.app.dto.CategoriaDTO;
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
@Table(name="cat_categoria",schema="public")
public class CategoriaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int catNrId;

    @OneToOne
    @JoinColumn(name = "cat_tor_nr_id", referencedColumnName = "torNrId")
    private TorneioModel torneio;

    @Column( nullable = false, length = 100)
    private String catTxNome;


    public CategoriaDTO toCategoria() {
        return CategoriaDTO.builder()
                .catNrId(catNrId)
                .torneio(torneio)
                .catTxNome(catTxNome)
                .build();
    }

}

