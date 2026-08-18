package com.example.exerciselog.service;

import com.example.exerciselog.domain.ExerciseLog;
import com.example.exerciselog.mapper.ExerciseLogMapper;
import org.springframework.stereotype.Service;

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
}
