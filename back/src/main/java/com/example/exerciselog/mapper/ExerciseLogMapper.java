package com.example.exerciselog.mapper;

import com.example.exerciselog.domain.ExerciseLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseLogMapper {

    List<ExerciseLog> findAll();

    void insert(ExerciseLog exerciseLog);
}
