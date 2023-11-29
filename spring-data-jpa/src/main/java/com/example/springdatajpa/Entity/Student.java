package com.example.springdatajpa.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //to interact with db
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_student",
    uniqueConstraints =  @UniqueConstraint(
            name = "emailId_unique",columnNames = "email_id"))
//it will create new table in this name and it make sure email id is unique
public class Student {


    @Id //to act as primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name="email_id",
            nullable=false
    )
    private String emailId;

    @Embedded
    private Gaurdian gaurdian;

}
