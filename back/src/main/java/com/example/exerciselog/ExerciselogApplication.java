package com.example.exerciselog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.exerciselog.mapper")
public class ExerciselogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciselogApplication.class, args);
	}

}
