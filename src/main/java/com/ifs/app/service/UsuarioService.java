package com.ifs.app.service;


import com.ifs.app.dto.UsuarioDTO;
import com.ifs.app.model.UsuarioModel;
import com.ifs.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAll() {
        List<UsuarioModel> lsUsuario = (List<UsuarioModel>) usuarioRepository.findAll();
        List<UsuarioDTO> lsUsuDTO = new ArrayList<>();
        lsUsuario.forEach(item -> {
            lsUsuDTO.add(item.toUsuario());
        });
        return lsUsuDTO;
    }

    public UsuarioModel cadastrar (UsuarioDTO usuarioDTO) throws Exception{
        usuarioDTO.setUsuDtCadstro(LocalDateTime.now());
        usuarioDTO.getUsuTxNome();
        Optional<UsuarioModel> op =  usuarioRepository.findByUsuTxLoginIgnoreCase(usuarioDTO.getUsuTxLogin());
        System.out.println(op);
        if (op.isPresent()) {
            throw new Exception("Login já existente");
        }
        return usuarioRepository.save(usuarioDTO.toUsuario());

    }

    public UsuarioDTO getByLogin(String login) throws Exception{
        Optional<UsuarioModel> op = usuarioRepository.findByUsuTxLoginIgnoreCase(login);
        if (op != null) {
            return op.get().toUsuario();
        }
        throw new Exception("Usuário não encontrado!");
    }
    public UsuarioDTO getById(int id) {
        return usuarioRepository.getByUsuNrId(id).toUsuario();
    }

}
