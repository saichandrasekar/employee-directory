package com.sai.backend.service;

import com.sai.backend.viewobject.EmployeeVO;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeVO> getAllEmployees();
}
