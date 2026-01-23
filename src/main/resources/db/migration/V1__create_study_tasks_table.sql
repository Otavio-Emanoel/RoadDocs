-- Migration V1: Criar tabela study_tasks
CREATE TABLE study_tasks (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    content TEXT,
    priority VARCHAR(50),
    completed BOOLEAN DEFAULT FALSE
);

-- Índices para melhorar performance
CREATE INDEX idx_study_tasks_priority ON study_tasks(priority);
CREATE INDEX idx_study_tasks_completed ON study_tasks(completed);
