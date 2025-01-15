package com.alura.foro_hub.controller;

import com.alura.foro_hub.topico.DatosTopico;
import com.alura.foro_hub.topico.Topico;
import com.alura.foro_hub.topico.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Topico> listadoDeTopicos(){
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional
    public Topico obtenerTopicoUsandoId(@PathVariable Long id){
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topico not found with id: " + id));
        return topico;
    }

    @PutMapping("/{id}")
    @Transactional
    public Topico actualizarTopicoUsandoId(@RequestBody @Valid DatosTopico datosTopicosParaActualizar,@PathVariable Long id){
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topico not found with id: " + id));
        topico.actualizarDatos(datosTopicosParaActualizar, topicoRepository);
        return topico;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void borrarTopicoUsandoId(@PathVariable Long id){
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topico not found with id: " + id));
        topicoRepository.deleteById(id);
        System.out.println("Topico con id: "+ id +" borrado correctamente");
    }
}
