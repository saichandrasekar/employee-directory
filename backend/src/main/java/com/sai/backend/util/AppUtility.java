package com.sai.backend.util;

import com.sai.backend.entity.Department;
import com.sai.backend.entity.Employee;
import com.sai.backend.viewobject.DepartmentVO;
import com.sai.backend.viewobject.EmployeeVO;

import java.sql.Date;

public class AppUtility {

    public static Employee copyFrom(final EmployeeVO employeeVO) {
        if (employeeVO == null) {
            return null;
        } else {
            Employee employee = new Employee(employeeVO.getFirstName(), employeeVO.getLastName(), employeeVO.getSalary(), employeeVO.getPhoneNumber());
            employee.setEmployeeId(employeeVO.getEmployeeId());
            employee.setEmail(employeeVO.getEmail());
            employee.setSalary(employeeVO.getSalary());
            employee.setManagerId(employeeVO.getManagerId());
            employee.setDepartmentId(employeeVO.getDepartmentId());
            employee.setHireDate(new Date(employeeVO.getHireDate().getTimeInMillis()));
            return employee;
        }
    }

    public static EmployeeVO copyFrom(final Employee employee) {
        if (employee == null) {
            return null;
        } else {
            EmployeeVO employeeVO = new EmployeeVO(employee);
            return employeeVO;
        }
    }

    public static Department copyFrom(DepartmentVO departmentVO) {
        if (departmentVO == null) {
            return null;
        } else {
            Department department = new Department(departmentVO.getDepartmentName(), departmentVO.getManagerId());
            department.setDepartmentId(departmentVO.getDepartmentId());

            return department;
        }
    }

    public static DepartmentVO copyFrom(Department departmentSaved) {
        if (departmentSaved == null) {
            return null;
        } else {
            DepartmentVO departmentVO = new DepartmentVO(departmentSaved);
            return departmentVO;
        }
    }
}
