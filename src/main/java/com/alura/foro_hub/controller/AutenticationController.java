package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.usuarios.DatosAutenticacionUsuarios;
import com.alura.foro_hub.domain.usuarios.Usuarios;
import com.alura.foro_hub.infra.security.DatosJWTToken;
import com.alura.foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuarios datosAutenticacionUsuarios){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuarios.login()
                ,datosAutenticacionUsuarios.clave());
        authenticationManager.authenticate(authToken);
        var usuarioAutenticado= authenticationManager.authenticate(authToken);
        var JWTtoken=tokenService.generarToken((Usuarios) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));

    }
}
