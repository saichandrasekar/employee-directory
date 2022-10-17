package com.sai.backend.service.impl;

import com.sai.backend.service.IEmployeeService;
import com.sai.backend.viewobject.EmployeeVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    public List<EmployeeVO> getAllEmployees(){
        return new ArrayList<>();
    }
}
