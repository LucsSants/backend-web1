package com.ifs.app.service;

import com.ifs.app.data.DetalheUsuarioData;
import com.ifs.app.model.UsuarioModel;
import com.ifs.app.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public DetalheUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuario =  usuarioRepository.findByUsuTxLoginIgnoreCase(username);
        System.out.println(username);
        System.out.println(!usuario.isPresent());
        if (!usuario.isPresent()) {
            System.out.println("AAAAAAA");
            throw new UsernameNotFoundException("Usuário: ["+ username + "] não encontrado!" );

        }
        return new DetalheUsuarioData(usuario);

    }
}
