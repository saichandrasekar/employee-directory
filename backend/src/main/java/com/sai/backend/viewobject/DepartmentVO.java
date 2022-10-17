package com.sai.backend.viewobject;

public class DepartmentVO {

    private Integer departmentId;

    private String departmentName;

    private Integer managerId;

    private EmployeeVO manager;

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

    public EmployeeVO getManager() {
        return manager;
    }

    public void setManager(EmployeeVO manager) {
        this.manager = manager;
    }
}
