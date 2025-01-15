package com.alura.foro_hub.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    // Método para verificar si existe un título con un ID diferente
    boolean existsByTituloAndIdNot(String titulo, Long id);

    // Método para verificar si existe un mensaje con un ID diferente
    boolean existsByMensajeAndIdNot(String mensaje, Long id);
}
