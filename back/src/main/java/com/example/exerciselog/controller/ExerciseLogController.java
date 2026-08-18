package com.example.exerciselog.controller;

import com.example.exerciselog.domain.ExerciseLog;
import com.example.exerciselog.service.ExerciseLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exercise-logs")
public class ExerciseLogController {

    private final ExerciseLogService exerciseLogService;

    public ExerciseLogController(ExerciseLogService exerciseLogService) {
        this.exerciseLogService = exerciseLogService;
    }

    @GetMapping
    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogService.getExerciseLogs();
    }
}
