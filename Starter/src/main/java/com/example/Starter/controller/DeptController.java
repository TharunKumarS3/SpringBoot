package com.example.Starter.controller;

import com.example.Starter.entity.Department;
import com.example.Starter.errors.DeptNotFoundException;
import com.example.Starter.service.DeptService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    private final Logger LOGGER= LoggerFactory.getLogger(DeptController.class);

    @PostMapping("/departments") //getting json objec and converting to department obj
    //whenever we getting json obj we cheching deptName should present so @Valid
    public Department savedept(@Valid @RequestBody Department department)
    {
        LOGGER.info("inside save department");
        return deptService.saveDepartMent(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchDept()
    {
        LOGGER.info("inside fetch records");
        return deptService.fetchDeptDdetails();
    }
    //fetching data by id
    @GetMapping("/departments/{id}")
    public Department fetchById(@PathVariable("id") Long deptId) throws DeptNotFoundException {
        return deptService.fetchId(deptId);
    }

    //delete by id
    @DeleteMapping("/departments/{id}")
    public String delById(@PathVariable("id") Long deptId)
    {
        deptService.deletById(deptId);
        return "SuccessFully Deleted";
    }

    //updating
    @PutMapping("/departments/{id}")
    public Department updateDept(@PathVariable("id") Long deptId,@RequestBody Department department)
    {
        return deptService.updateDeptId(deptId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department findByName(@PathVariable("name") String deptName)
    {
        return deptService.findbyname(deptName);
    }



}
