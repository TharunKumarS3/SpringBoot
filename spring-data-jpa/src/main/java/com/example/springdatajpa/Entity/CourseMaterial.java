package com.example.springdatajpa.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseMaterialId;
    private String url;

    //without course this clss wont exist
    //so add one to one relationship
    @OneToOne(
            cascade = CascadeType.ALL,
            //fetchlazy only get child data not parent's data
            fetch= FetchType.LAZY,
            optional = false
    )
    //map which column to match
    @JoinColumn(
            name = "corse_id",
            referencedColumnName = "courseId"
    )
    private  Course course;
}
