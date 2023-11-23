package com.example.Starter.service;

import com.example.Starter.entity.Department;
import com.example.Starter.errors.DeptNotFoundException;
import com.example.Starter.repository.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptRepo deptRepo;
    @Override
    public Department saveDepartMent(Department department) {
        return deptRepo.save(department);
    }

    @Override
    public List<Department> fetchDeptDdetails() {
        return deptRepo.findAll();
    }

    @Override
    public Department fetchId(Long deptId) throws DeptNotFoundException {
        //Exceptional handling if dept id not present in database
         Optional<Department> departmentOptional=deptRepo.findById(deptId);
         if(!departmentOptional.isPresent())
         {
             throw new DeptNotFoundException("Department not available");
         }
         return departmentOptional.get();
    }

    @Override
    public void deletById(Long deptId) {
        deptRepo.deleteById(deptId);
    }

    @Override
    public Department updateDeptId(Long deptId, Department department) {
        Department d=deptRepo.findById(deptId).get(); //finding that particular record

        //we r getting id and json onject from url for updation
        //department object holds new value for updation
        if(Objects.nonNull(department.getDeptName()) && !"".equalsIgnoreCase(department.getDeptName()))
        {
            d.setDeptName(department.getDeptName());
        }
        if(Objects.nonNull(department.getDeptAddress()) && !"".equalsIgnoreCase(department.getDeptAddress()))
        {
            d.setDeptAddress(department.getDeptAddress());
        }
        if(Objects.nonNull(department.getDeptCode()) && !"".equalsIgnoreCase(department.getDeptCode()))
        {
            d.setDeptCode(department.getDeptCode());
        }
        return deptRepo.save(d);
    }

    @Override
    public Department findbyname(String deptName) {
        return deptRepo.findBydeptNameIgnoreCase(deptName);
    }


}
