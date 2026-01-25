package com.roaddocs.roaddocs.dto;

/**
 * DTO para RETORNAR dados ao cliente.
 * Apenas dados públicos que a API deve expor.
 */
public record StudyTaskResponse(
    Long id,
    String title,
    String description,
    String content,
    String priority,
    boolean completed
) {}
