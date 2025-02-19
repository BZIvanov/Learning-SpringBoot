package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
    private final ApplicationContext context;

    @Autowired
    public DemoRunner(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        // calling all methods and you will see Aspect logs in the console only for methods matching the @Before pattern

        StudentService studentService = context.getBean(StudentService.class);
        studentService.getStudentInfo();
        studentService.getSchoolName();
        studentService.addGrade(4.5);

        TeacherService teacherService = context.getBean(TeacherService.class);
        teacherService.getTeacherInfo();
        teacherService.getSchoolName();
        teacherService.addSubject(new Subject("Math"));
        teacherService.addSubject(new Subject("History"), 8);
    }
}
