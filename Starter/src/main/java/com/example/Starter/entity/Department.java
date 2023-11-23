package com.example.Starter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //to interatct with db
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //this will help to create obj with custom properties constructor
//like if we have 10 properties we need to pass all 10 prop to constructor
//so this is hard @Builder help to pass any no of prop to get the bean
public class Department {

    @Id //to act as primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    @NotBlank(message = "Please add Department name")
    private String deptName;
    private String deptAddress;
    private String deptCode;


    //this all code is replaced by lombok library
//    public Department() {
//    }
//
//    public Department(Long deptId, String deptName, String deptAddress, String deptCode) {
//        this.deptId = deptId;
//        this.deptName = deptName;
//        this.deptAddress = deptAddress;
//        this.deptCode = deptCode;
//    }
//
//    public Long getDeptId() {
//        return deptId;
//    }
//
//    public void setDeptId(Long deptId) {
//        this.deptId = deptId;
//    }
//
//    public String getDeptName() {
//        return deptName;
//    }
//
//    public void setDeptName(String deptName) {
//        this.deptName = deptName;
//    }
//
//    public String getDeptAddress() {
//        return deptAddress;
//    }
//
//    public void setDeptAddress(String deptAddress) {
//        this.deptAddress = deptAddress;
//    }
//
//    public String getDeptCode() {
//        return deptCode;
//    }
//
//    public void setDeptCode(String deptCode) {
//        this.deptCode = deptCode;
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "deptId=" + deptId +
//                ", deptName='" + deptName + '\'' +
//                ", deptAddress='" + deptAddress + '\'' +
//                ", deptCode='" + deptCode + '\'' +
//                '}';
//    }
}
