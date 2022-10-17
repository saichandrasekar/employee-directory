package com.sai.backend.service;

import com.sai.backend.viewobject.EmployeeVO;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeVO> getAllEmployees(final int page, final int size);

    EmployeeVO saveEmployee(final EmployeeVO employeeVO);

    EmployeeVO updateEmployee(final EmployeeVO employeeVO);

    void deleteEmployee(final Integer employeeId);
}
