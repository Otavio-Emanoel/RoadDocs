package com.roaddocs.roaddocs.service;

import org.springframework.stereotype.Service;
import com.roaddocs.roaddocs.dto.StudyTaskRequest;
import com.roaddocs.roaddocs.dto.StudyTaskResponse;
import com.roaddocs.roaddocs.entities.StudyTask;

@Service
public class StudyTaskMapper {

    /**
     * Converte DTO de entrada em entidade JPA
     */
    public StudyTask toEntity(StudyTaskRequest request) {
        return new StudyTask(
            request.title(),
            request.description(),
            request.completed(),
            request.content(),
            request.priority()
        );
    }

    /**
     * Converte entidade JPA em DTO de resposta
     */
    public StudyTaskResponse toResponse(StudyTask task) {
        return new StudyTaskResponse(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getContent(),
            task.getPriority(),
            task.isCompleted()
        );
    }
}
