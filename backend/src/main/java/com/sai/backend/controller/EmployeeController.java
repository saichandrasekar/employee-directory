package com.sai.backend.controller;

import com.sai.backend.service.IEmployeeService;
import com.sai.backend.viewobject.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/backend/v1/employee")
    public List<EmployeeVO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}
