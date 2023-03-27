package com.ifs.app.repository;


import com.ifs.app.dto.UsuarioDTO;
import com.ifs.app.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByUsuTxLoginIgnoreCase(String login);

    UsuarioModel getByUsuNrId( int id);



}
