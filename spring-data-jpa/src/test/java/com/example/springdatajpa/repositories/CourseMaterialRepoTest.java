package com.example.springdatajpa.repositories;

import com.example.springdatajpa.Entity.Course;
import com.example.springdatajpa.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepo courseMaterialRepo;

    @Test
    public void save()
    {

        Course course=Course.builder()
                .title("SpringBoot")
                .credit(3)
                .build();


        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        //before saving we have to cascade
        //bcoz we are not saving course entities we are saving course material entities so
        //we need use cascade to tell its ok u persist course obj also
        //see in courseMatrial class for cascade
        courseMaterialRepo.save(courseMaterial);
    }
    @Test
    public void printCourseMaterial()
    {
        List<CourseMaterial> courseMaterials=courseMaterialRepo.findAll();
        System.out.println(courseMaterials);
    }

}