package com.example.mycrudapp;

import com.example.mycrudapp.dao.StudentDAO;
import com.example.mycrudapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MycrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycrudappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// uncomment whichever method below you want to test
			createStudent(studentDAO);

			// readStudent(studentDAO);

			// readAllStudents(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Iva", "Ivanova", "iva@mail.com");
		studentDAO.create(student);
	}

	private void readStudent(StudentDAO studentDAO) {
		int studentId = 1;

		Student student = studentDAO.findById(studentId);
		System.out.println(student);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		System.out.println(students);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		Student student = studentDAO.findById(studentId);

		student.setFirstName("Irena");

		studentDAO.update(student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		studentDAO.delete(studentId);
	}
}
