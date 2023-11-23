package com.example.Starter.repository;

import com.example.Starter.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepo extends JpaRepository<Department,Long> {

    //we are creating custom method for feching by name
    public Department findBydeptNameIgnoreCase(String  deptName);
}
