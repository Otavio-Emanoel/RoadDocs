package com.roaddocs.roaddocs.dto;

/**
 * DTO para RECEBER dados do cliente.
 * Sem o ID (gerado pelo banco) e sem timestamps.
 */
public record StudyTaskRequest(
    String title,
    String description,
    String content,
    String priority,
    boolean completed
) {}
