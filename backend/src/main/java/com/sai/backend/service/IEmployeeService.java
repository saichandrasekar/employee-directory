package com.sai.backend.service;

import com.sai.backend.viewobject.EmployeeVO;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeVO> getAllEmployees();

    EmployeeVO saveEmployee(final EmployeeVO employeeVO);

    Integer updateEmployee(final EmployeeVO employeeVO);

    void deleteEmployee(final Integer employeeId);
}
