package com.example.Starter.service;

import com.example.Starter.entity.Department;
import com.example.Starter.repository.DeptRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeptServiceTest {
    @Autowired
    private  DeptService deptService;

    @MockBean
    private DeptRepo deptRepo; // we r not going to care about repo layer so we just want dummy bean



    @BeforeEach //this method is called everytime for all @Test methods we created
    void setUp() {
            Department department=Department.builder().deptId(1L)
                    .deptAddress("SITE")
                    .deptCode("MCA01")
                    .deptName("MCA").build();

        Mockito.when(deptRepo.findBydeptNameIgnoreCase("MCA")).thenReturn(department);

    }
    @Test
    @DisplayName("Get data based on valid dept name")
    public void whenValidDeptNameThenDeptShouldFound()
    {
        String deptName="MCA";
        Department found=deptService.findbyname(deptName); //this findbyname will go to depReo layer
        //so we need to mock that repolayer's obj
        //in above setup method will generate tha work that findbyname() wants to do
        //it will return the result herek

        //---
        //checking is both are equal
        assertEquals(deptName,found.getDeptName());

    }
}