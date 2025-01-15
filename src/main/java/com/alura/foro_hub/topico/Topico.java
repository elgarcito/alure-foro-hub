package com.alura.foro_hub.topico;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;
    private String status;
    private String autor;
    private String curso;

    // Constructor
    public Topico(DatosTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaDeCreacion = datosTopico.fechaDeCreacion();
        this.status = datosTopico.status();
        this.autor = datosTopico.autor();
        this.curso = datosTopico.curso();
    }


    // Default constructor (required by Hibernate)
    public Topico() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void actualizarDatos(DatosTopico datosTopico, TopicoRepository topicoRepository) {
        if (datosTopico.titulo() != null) {
            // Verificar si el título ya existe en otro registro
            boolean tituloExistente = topicoRepository.existsByTituloAndIdNot(datosTopico.titulo(), this.id);
            if (tituloExistente) {
                throw new IllegalArgumentException("El título ya está en uso por otro tópico.");
            }
            this.titulo = datosTopico.titulo();
        }

        if (datosTopico.mensaje() != null) {
            // Verificar si el mensaje ya existe en otro registro
            boolean mensajeExistente = topicoRepository.existsByMensajeAndIdNot(datosTopico.mensaje(), this.id);
            if (mensajeExistente) {
                throw new IllegalArgumentException("El mensaje ya está en uso por otro tópico.");
            }
            this.mensaje = datosTopico.mensaje();
        }

        if (datosTopico.fechaDeCreacion() != null) {
            this.fechaDeCreacion = datosTopico.fechaDeCreacion();
        }

        if (datosTopico.status() != null) {
            this.status = datosTopico.status();
        }

        if (datosTopico.autor() != null) {
            this.autor = datosTopico.autor();
        }

        if (datosTopico.curso() != null) {
            this.curso = datosTopico.curso();
        }
    }

}
