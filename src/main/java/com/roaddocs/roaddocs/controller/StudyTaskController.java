package com.roaddocs.roaddocs.controller;

import org.springframework.web.bind.annotation.*;
import com.roaddocs.roaddocs.dto.StudyTaskRequest;
import com.roaddocs.roaddocs.dto.StudyTaskResponse;
import com.roaddocs.roaddocs.service.StudyTaskMapper;

/**
 * ❌ FORMA ERRADA - Expor entidade JPA direto:
 * 
 * @PostMapping("/tasks")
 * public StudyTask create(@RequestBody StudyTask task) {
 *     return repository.save(task);
 * }
 * 
 * Problemas:
 * - Serializa TUDO da entidade (campos internos, lazy-loaded collections)
 * - Cliente pode enviar IDs ou dados sensíveis
 * - Difícil evoluir API sem quebrar banco
 * - Vazamento de detalhes de implementação
 */

/**
 * ✅ FORMA CORRETA - Usar DTOs:
 */
@RestController
@RequestMapping("/api/tasks")
public class StudyTaskController {

    private final StudyTaskMapper mapper;

    public StudyTaskController(StudyTaskMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Recebe StudyTaskRequest (sem ID)
     * Retorna StudyTaskResponse (com ID gerado)
     */
    @PostMapping
    public StudyTaskResponse create(@RequestBody StudyTaskRequest request) {
        // Converter DTO → Entidade
        var task = mapper.toEntity(request);
        // Aqui você salvaria no banco
        // task = repository.save(task);
        // Converter Entidade → DTO de resposta
        return mapper.toResponse(task);
    }

    /**
     * Retorna apenas StudyTaskResponse
     * Nunca a entidade completa
     */
    @GetMapping("/{id}")
    public StudyTaskResponse getById(@PathVariable Long id) {
        // var task = repository.findById(id).orElseThrow();
        // return mapper.toResponse(task);
        return null; // Exemplo
    }
}
