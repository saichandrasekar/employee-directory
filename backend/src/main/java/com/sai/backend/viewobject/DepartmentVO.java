package com.sai.backend.viewobject;

import com.sai.backend.entity.Department;

public class DepartmentVO {

    private Integer departmentId;

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
