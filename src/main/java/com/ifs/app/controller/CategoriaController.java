package com.ifs.app.controller;

import com.ifs.app.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public Object getByTorneio(@PathVariable(value = "id") int id){
        return categoriaService.getAllTorById(id);
    }
}
