package com.example.exerciselog.controller;

import com.example.exerciselog.domain.ExerciseLog;
import com.example.exerciselog.dto.ExerciseLogRegisterRequest;
import com.example.exerciselog.service.ExerciseLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @PostMapping
    public ResponseEntity<ExerciseLog> registerExerciseLog(@RequestBody ExerciseLogRegisterRequest request) {
        ExerciseLog created = exerciseLogService.registerExerciseLog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleInvalidRequest(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", ex.getMessage()));
    }
}
