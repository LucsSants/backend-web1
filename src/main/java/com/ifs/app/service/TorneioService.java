package com.ifs.app.service;

import com.ifs.app.dto.TorneioDTO;
import com.ifs.app.dto.UsuarioDTO;
import com.ifs.app.model.TorneioModel;
import com.ifs.app.repository.TorneioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TorneioService {
    @Autowired
    TorneioRepository torneioRepository;

    public List<TorneioDTO> getAll() {
        List<TorneioModel> lsTorneioModel = (List<TorneioModel>) torneioRepository.findAll();
        List<TorneioDTO> lsTorneioDTO = new ArrayList<>();
        lsTorneioModel.forEach(item -> {
            lsTorneioDTO.add(item.toTorneio());
        });
        return lsTorneioDTO;
    }

}
