package com.ifs.app.repository;

import com.ifs.app.dto.CategoriaDTO;
import com.ifs.app.dto.UsuarioDTO;
import com.ifs.app.model.CategoriaModel;
import com.ifs.app.model.InscricaoModel;
import com.ifs.app.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscricaoRepository extends CrudRepository<InscricaoModel, Integer> {
    Optional<InscricaoModel> getByUsuarioUmAndAndCategoria (UsuarioModel usuario, CategoriaModel categoria);
    Optional<InscricaoModel>  getByUsuarioDois (UsuarioModel usuario);
}

