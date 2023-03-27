package com.ifs.app.repository;

import com.ifs.app.model.CategoriaModel;
import com.ifs.app.model.TorneioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaModel, Integer> {
    List<CategoriaModel> findAllByTorneio_TorNrId(int torneioId);
    CategoriaModel getByCatNrId(int id);
}
