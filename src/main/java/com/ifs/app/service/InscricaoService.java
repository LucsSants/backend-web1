package com.ifs.app.service;

import com.ifs.app.dto.CategoriaDTO;
import com.ifs.app.dto.InscricaoDTO;
import com.ifs.app.dto.UsuarioDTO;
import com.ifs.app.model.CategoriaModel;
import com.ifs.app.model.InscricaoModel;
import com.ifs.app.model.UsuarioModel;
import com.ifs.app.repository.CategoriaRepository;
import com.ifs.app.repository.InscricaoRepository;
import com.ifs.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InscricaoService {
    @Autowired
    InscricaoRepository inscricaoRepository;

    public InscricaoModel novaInscricao (InscricaoDTO inscricaoDTO) throws Exception{

        return inscricaoRepository.save(inscricaoDTO.toInscricao());
    }
}
