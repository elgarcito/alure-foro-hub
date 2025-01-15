package com.alura.foro_hub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDateTime fechaDeCreacion,
        @NotBlank
        String status,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
