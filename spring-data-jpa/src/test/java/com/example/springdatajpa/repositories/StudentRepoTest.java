package com.example.springdatajpa.repositories;

import com.example.springdatajpa.Entity.Gaurdian;
import com.example.springdatajpa.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudentWithGaurdian()
    {
        Gaurdian gaurdian=Gaurdian.builder()
                .guardianName("ronaldo")
                .guardianMail("ronaldo@gmail.com")
                .guardianMobile("123455")
                .build();

        Student student=Student.builder()
                .firstName("tharun")
                .lastName("kumar")
                .emailId("tharun@gmail.com")
                .gaurdian(gaurdian)
                .build();

        studentRepo.save(student);
    }
    @Test
    public void printStudentByFirstName() {

        List<Student> students =
                studentRepo.findByFirstName("tharun");

        System.out.println("students = " + students);
    }

    @Test
    public void printbysearch()
    {
        List<Student> students=studentRepo.findByFirstNameContaining("arun");
        System.out.println("students = "+ students);
    }
    @Test
    public  void findlast()
    {
        List<Student> students=studentRepo.findByLastNameNotNull();
        System.out.println("students = "+ students);

    }
    @Test
    public void printgetStudentByEmailAddress() {
        Student student =
                studentRepo.getStudentByEmail(
                        "tharun@gmail.com"
                );

        System.out.println("student = " + student);
    }
    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepo.getByEmailId("tharun@gmail.com");

        System.out.println("student = " + student);
    }
    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepo.updateStudentNameByEmailId(
                "Tharun",
                "tharun@gmail.com");
    }

}