package com.example.springjpaproject.repository;


import com.example.springjpaproject.entity.Course;
import com.example.springjpaproject.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TeacherRepositoryTest {

    private final TeacherRepository teacherRepository;

    @Autowired
    TeacherRepositoryTest(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("Intro")
                .credit(2)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("edu")
                .lastName("chagas")
                //.courses(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }
}