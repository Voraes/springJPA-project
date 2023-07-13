package com.example.springjpaproject.repository;

import com.example.springjpaproject.entity.Guardian;
import com.example.springjpaproject.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    private final StudentRepository studentRepository;

    public StudentRepositoryTest(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("vic@gmail.com")
                .firstName("victor")
                .lastName("mendes")
                /*.guardianName("Guar")
                .guardianEmail("guar@gmail.com")
                .guardianMobile("999999999")*/
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("dian@gmail.com")
                .name("dian")
                .mobile("888888888")
                .build();

        Student student = Student.builder()
                .emailId("gab@gmail.com")
                .firstName("gab")
                .lastName("moraes")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("gab");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("g");
        System.out.println(studentList);
    }

    /*@Test
    public void printStudentByLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull("moraes");
        System.out.println(studentList);
    }*/

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("dian");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("gab", "moraes");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("vic@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("vic@gmail.com");
        System.out.println(studentFirstName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("vic@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("vic@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId(
                "victor",
                "vic@gmail.com"
        );
    }
}