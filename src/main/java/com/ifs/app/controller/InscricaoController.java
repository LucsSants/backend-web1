package com.ifs.app.controller;

import com.ifs.app.dto.InscricaoDTO;
import com.ifs.app.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {
    @Autowired
    InscricaoService inscricaoService;

    @RequestMapping
    public Object novaInscricao(@RequestBody InscricaoDTO inscricaoDTO) throws Exception {
        return inscricaoService.novaInscricao(inscricaoDTO);
    }

}
