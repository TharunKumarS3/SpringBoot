package com.example.springdatajpa.repositories;


import com.example.springdatajpa.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

        List<Student> findByFirstName(String name);

        List<Student> findByFirstNameContaining(String name);

        List<Student> findByLastNameNotNull();

        //custom method with jpql query
        //here we have to mention class name instead of table name
        @Query("select s from Student s where s.emailId=?1")
        public Student getStudentByEmail(String emailId);

        //custom method with native query with param
        @Query(
                value = "SELECT * FROM tbl_student s where s.email_id = :emailId",
                nativeQuery = true
        )
        public Student getByEmailId(@Param("emailId") String emailId);
        //@Param will match to the emailid in query


        //for updating
        @Modifying
        @Transactional
        @Query(
                value = "update tbl_student set first_name = ?1 where email_id = ?2",
                nativeQuery = true
        )
        int updateStudentNameByEmailId(String firstName, String emailId);
}
