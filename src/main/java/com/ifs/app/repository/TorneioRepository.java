package com.ifs.app.repository;


import com.ifs.app.model.TorneioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneioRepository extends CrudRepository<TorneioModel, Integer> {
}

