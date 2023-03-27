package com.ifs.app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifs.app.data.DetalheUsuarioData;
import com.ifs.app.model.UsuarioModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 600_000;
    public static final String TOKEN_SENHA = "0b3ce758-58f7-4441-bd6b-0b960d360f81";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UsuarioModel usuario = new ObjectMapper().readValue(request.getInputStream(), UsuarioModel.class);
            System.out.println(usuario.getUsuTxLogin() + 1);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getUsuTxLogin(),
                    usuario.getUsuTxSenha(),
                    new ArrayList<>()
            ));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            try {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Falha ao autenticar usuário");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException("Falha ao autenticar usuário",e);

        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();
        String token = JWT.create().
                withSubject(usuarioData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));
        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
