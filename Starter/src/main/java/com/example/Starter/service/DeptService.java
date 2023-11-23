package com.example.Starter.service;

import com.example.Starter.entity.Department;
import com.example.Starter.errors.DeptNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptService {
    Department saveDepartMent(Department department);

    public List<Department> fetchDeptDdetails();

    public Department fetchId(Long deptId) throws DeptNotFoundException;

    public void deletById(Long deptId);

    public Department updateDeptId(Long deptId, Department department);

    public Department findbyname(String deptName);
}
