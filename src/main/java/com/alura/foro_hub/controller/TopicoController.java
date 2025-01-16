package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.topico.DatosTopico;
import com.alura.foro_hub.domain.topico.Topico;
import com.alura.foro_hub.domain.topico.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Topico>> listadoDeTopicos(){
        return ResponseEntity.ok(topicoRepository.findAll());
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity obtenerTopicoUsandoId(@PathVariable Long id){
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topico not found with id: " + id));
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopicoUsandoId(@RequestBody @Valid DatosTopico datosTopicosParaActualizar,@PathVariable Long id){
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topico not found with id: " + id));
        topico.actualizarDatos(datosTopicosParaActualizar, topicoRepository);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity borrarTopicoUsandoId(@PathVariable Long id){
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topico not found with id: " + id));
        topicoRepository.deleteById(id);
        System.out.println("Topico con id: "+ id +" borrado correctamente");
        return ResponseEntity.noContent().build();
    }
}
