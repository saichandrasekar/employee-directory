package com.sai.backend.util;

import com.sai.backend.entity.Employee;
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

            // TODO: Sai
            //employee.setHireDate(new Date());

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
}
