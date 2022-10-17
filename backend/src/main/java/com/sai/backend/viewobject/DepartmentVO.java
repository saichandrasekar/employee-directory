package com.sai.backend.viewobject;

import com.sai.backend.entity.Department;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class DepartmentVO {

    private Integer departmentId;

    @NotBlank(message = "The department name is required")
    @Size(min = 1, max = 30, message = "The length of department name must be between 1 and 30")
    private String departmentName;


    private Integer managerId;

    public DepartmentVO(){
    }

    public DepartmentVO(Department department) {
        this.departmentId = department.getDepartmentId();
        this.departmentName = department.getDepartmentName();
        this.managerId = department.getManagerId();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

}
