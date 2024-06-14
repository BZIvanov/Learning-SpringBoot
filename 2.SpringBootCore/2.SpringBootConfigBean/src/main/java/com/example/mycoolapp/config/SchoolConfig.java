package com.example.mycoolapp.config;

import com.example.mycoolapp.common.DanceTeacher;
import com.example.mycoolapp.common.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfig {
    @Bean
    public Teacher danceTeacher() {
        return new DanceTeacher();
    }
}
