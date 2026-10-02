package com.example.exerciselog.service;

import com.example.exerciselog.domain.ExerciseLog;
import com.example.exerciselog.dto.ExerciseLogRegisterRequest;
import com.example.exerciselog.mapper.ExerciseLogMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExerciseLogService {

    private final ExerciseLogMapper exerciseLogMapper;

    public ExerciseLogService(ExerciseLogMapper exerciseLogMapper) {
        this.exerciseLogMapper = exerciseLogMapper;
    }

    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogMapper.findAll();
    }

    public ExerciseLog registerExerciseLog(ExerciseLogRegisterRequest request) {
        validate(request);

        ExerciseLog exerciseLog = new ExerciseLog();
        exerciseLog.setExerciseName(request.getExerciseName());
        exerciseLog.setExerciseDate(
                request.getExerciseDate() != null ? request.getExerciseDate() : LocalDate.now());
        exerciseLog.setDurationMinutes(request.getDurationMinutes());
        exerciseLog.setWeight(request.getWeight());
        exerciseLog.setReps(request.getReps());
        exerciseLog.setSets(request.getSets());

        exerciseLogMapper.insert(exerciseLog);
        return exerciseLog;
    }

    private void validate(ExerciseLogRegisterRequest request) {
        if (request.getExerciseName() == null || request.getExerciseName().isBlank()) {
            throw new IllegalArgumentException("운동명은 필수입니다.");
        }
        if (request.getWeight() == null || request.getWeight() <= 0) {
            throw new IllegalArgumentException("중량은 0보다 커야 합니다.");
        }
        if (request.getReps() == null || request.getReps() < 1) {
            throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
        }
        if (request.getSets() == null || request.getSets() < 1) {
            throw new IllegalArgumentException("세트는 1 이상이어야 합니다.");
        }
    }
}
