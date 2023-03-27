package com.ifs.app.model;

import com.ifs.app.dto.InscricaoDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ins_inscricao",schema="public")
public class InscricaoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int insNrId;

    @ManyToOne
    @JoinColumn(name = "ins_cat_nr_id", referencedColumnName = "catNrId")
    private CategoriaModel categoria;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ins_usu_nr_id1", referencedColumnName = "usuNrId")
    private UsuarioModel usuarioUm;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ins_usu_nr_id2", referencedColumnName = "usuNrId")
    private UsuarioModel usuarioDois;


    public InscricaoDTO toInscricao() {
        return InscricaoDTO.builder()
                .insNrId(insNrId)
                .categoria(categoria)
                .usuarioUm(usuarioUm)
                .usuarioDois(usuarioDois)
                .build();
    }


}




