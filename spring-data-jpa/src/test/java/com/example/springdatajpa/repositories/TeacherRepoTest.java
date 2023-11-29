package com.example.springdatajpa.repositories;

import com.example.springdatajpa.Entity.Course;
import com.example.springdatajpa.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {
    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void svaeTeacher()
    {
        Teacher teacher=Teacher.builder()
                .firstName("Cristiano")
                .lastName("Ronaldo")
              //  .courseList(saveCourse())
                .build();

        teacherRepo.save(teacher);
    }
    @Test
    public List<Course> saveCourse()
    {
        Course course=  Course.builder()
                .title("JAVA")
                .credit(3)
                .build();

        return List.of(course);

    }

}