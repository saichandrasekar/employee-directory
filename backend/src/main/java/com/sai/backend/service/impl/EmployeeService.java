package com.sai.backend.service.impl;

import com.sai.backend.BackendApplication;
import com.sai.backend.entity.Department;
import com.sai.backend.entity.Employee;
import com.sai.backend.exceptions.AppException;
import com.sai.backend.repository.EmployeePagingRepository;
import com.sai.backend.repository.EmployeeRepository;
import com.sai.backend.service.IEmployeeService;
import com.sai.backend.util.AppUtility;
import com.sai.backend.viewobject.DepartmentVO;
import com.sai.backend.viewobject.EmployeeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class EmployeeService implements IEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeePagingRepository employeePagingRepository;

    public List<EmployeeVO> getAllEmployees(final int page, final int size) {
        log.debug("EmployeeService: getAllEmployees: Fetching employees for page: "+page+" , size: "+size);
        final List<EmployeeVO> employeeVOs = new ArrayList<>();

        Pageable pageable = PageRequest.of(page, size);

        Iterable<Employee> employeeIterable = employeePagingRepository.findAll(pageable);
        if (employeeIterable != null) {
            employeeIterable.forEach(new Consumer<Employee>() {
                @Override
                public void accept(Employee employee) {
                    employeeVOs.add(new EmployeeVO(employee));
                }
            });
        }
        return employeeVOs;
    }

    public EmployeeVO saveEmployee(final EmployeeVO employeeVO) {
        Employee employee = AppUtility.copyFrom(employeeVO);
        employee.setEmployeeId(null);
        Employee employeeSaved = employeeRepository.save(employee);

        EmployeeVO employeeVOSaved = AppUtility.copyFrom(employeeSaved);
        return employeeVOSaved;
    }

    public EmployeeVO updateEmployee(final EmployeeVO employeeVO) {
        Employee employee = AppUtility.copyFrom(employeeVO);
        if(employeeRepository.existsById(employeeVO.getEmployeeId())){
            Employee employeeSaved = employeeRepository.save(employee);

            EmployeeVO employeeVOSaved = AppUtility.copyFrom(employeeSaved);
            return employeeVOSaved;
        }else{
            return null;
        }
    }

    public EmployeeVO getEmployeeById(final Integer employeeId) {
        return AppUtility.copyFrom(employeeRepository.findByEmployeeId(employeeId));
    }

    public void deleteEmployee(final Integer employeeId) throws AppException {
        try{
            employeeRepository.deleteById(employeeId);
        }catch(EmptyResultDataAccessException emptyResultDataAccessException){
            throw new AppException();
        }
    }
}
