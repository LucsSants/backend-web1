package com.ifs.app.controller;

import com.ifs.app.service.TorneioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/torneio")
public class TorneioController {
    @Autowired
    private TorneioService torneioService;

    @GetMapping
    public Object getAll(){
        return torneioService.getAll();
    }
}
