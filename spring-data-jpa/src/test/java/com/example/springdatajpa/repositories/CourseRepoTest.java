package com.example.springdatajpa.repositories;

import com.example.springdatajpa.Entity.Course;
import com.example.springdatajpa.Entity.Student;
import com.example.springdatajpa.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void getAllCourseWithMaterial()
    {
        List<Course>  courses=courseRepo.findAll();
        //it will get both course and coursematerial data together
        //bcoz we used one to one bidirectional
        System.out.println(courses);
    }
    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepo.save(course);
    }
    @Test
    public void findAllPagination()
    {
        Pageable firstPageWithThreeRecords= PageRequest.of(0,2);
        Pageable secondPageWithTwoRecords= PageRequest.of(0,3);

//        List<Course> courses=courseRepo.findAll(firstPageWithThreeRecords).getContent();
        List<Course> courses=courseRepo.findAll(secondPageWithTwoRecords).getContent();
        long totalPages=courseRepo.findAll(secondPageWithTwoRecords).getTotalPages();
        long totalelemnts=courseRepo.findAll(secondPageWithTwoRecords).getTotalElements();

        System.out.println(courses);
        System.out.println("total pages:"+totalPages);
        System.out.println("total elements: "+totalelemnts);
    }
    @Test
    public void findAllSorting()
    {
        Pageable sortByTitle=PageRequest.of(
                0,
                2,
                Sort.by("title")
        );
        Pageable sortByCreditdDesc=PageRequest.of(
                0,
                2,
                Sort.by("credit")
        );
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );
//        List<Course> courses=courseRepo.findAll(sortByTitle).getContent();
//        List<Course> courses=courseRepo.findAll(sortByCreditdDesc).getContent();
        List<Course> courses=courseRepo.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepo.save(course);
    }







}