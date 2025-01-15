package com.alura.foro_hub.controller;

import com.alura.foro_hub.topico.DatosTopico;
import com.alura.foro_hub.topico.Topico;
import com.alura.foro_hub.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
@Validated
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public void registrarTopico(@RequestBody @Valid DatosTopico datosTopico){
        topicoRepository.save(new Topico(datosTopico));
    }
}
