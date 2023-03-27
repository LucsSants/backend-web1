package com.ifs.app.service;

import com.ifs.app.dto.CategoriaDTO;
import com.ifs.app.dto.TorneioDTO;
import com.ifs.app.model.CategoriaModel;
import com.ifs.app.model.TorneioModel;
import com.ifs.app.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> getAllTorById(int torneioId) {
        List<CategoriaModel> lsCategoriaModel = (List<CategoriaModel>) categoriaRepository.findAllByTorneio_TorNrId(torneioId);
        List<CategoriaDTO> lsCategoriaDTO = new ArrayList<>();
        lsCategoriaModel.forEach(item -> {
            lsCategoriaDTO.add(item.toCategoria());
        });
        return lsCategoriaDTO;
    }

    public CategoriaDTO getById(int id) {
        return categoriaRepository.getByCatNrId(id).toCategoria();
    }
}
