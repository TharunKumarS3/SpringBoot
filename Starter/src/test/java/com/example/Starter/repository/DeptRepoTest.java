package com.example.Starter.repository;

import com.example.Starter.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DeptRepoTest {
    //without creating data in database we are testing the repo layer
    @Autowired
    private DeptRepo deptRepo;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        //we are storing dummy data to test repo layer
        Department department=Department.builder().deptName("MCA")
                .deptCode("MCA01")
                .deptAddress("SITE")
                .build();

        entityManager.persist(department);
    }

    @Test
    @DisplayName("Get by ID")
    public void whenFindByIdThenReturnDept()
    {
        Department department=deptRepo.findById(1l).get();
        assertEquals(department.getDeptName(),"MCA");

    }
}