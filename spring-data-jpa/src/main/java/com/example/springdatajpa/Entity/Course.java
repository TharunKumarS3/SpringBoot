package com.example.springdatajpa.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String title;
    private Integer credit;
    @OneToOne(
            //we have to get coureMaterials also whenever we get course
            //so we are mapping it to course object which was already in CourseMaterial.class

            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;


    //for many to many relation
    //we are creating new table in common to store studentI and courseId in it

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "studen_course_map",//new table name
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){
        if(students == null)
            students = new ArrayList<>();
        students.add(student);
    }
}
