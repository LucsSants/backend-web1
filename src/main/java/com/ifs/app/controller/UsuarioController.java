package com.ifs.app.controller;

import com.ifs.app.dto.UsuarioDTO;
import com.ifs.app.model.UsuarioModel;
import com.ifs.app.service.UsuarioService;
import com.ifs.app.utils.ResponseDefault;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/todos")
    public Object getAll() {
        return usuarioService.getAll();
    }

    @PostMapping
    public Object CadastrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        ResponseDefault response = new ResponseDefault();
        try {
            usuarioService.cadastrar(usuarioDTO);
            response.setMensagem("Usuário Criado com Sucesso");
            response.setValue(true);
            response.setCodigo(200);

        } catch (Exception e) {
            response.setCodigo(400);
            System.out.println(e.getMessage());
            response.setMensagem(e.getMessage());
            response.setValue(false);
        }
        return response;
    }

    @GetMapping("/get/{id}")
    public Object getById(@PathVariable(name = "id") int id) {
        return usuarioService.getById(id);
    }

    @GetMapping("/{user}")
    public Object getByUser(@PathVariable(name = "user") String user) throws Exception {
        return usuarioService.getByLogin(user);
    }

}
