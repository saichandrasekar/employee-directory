package com.sai.backend.service.impl;

import com.sai.backend.entity.Employee;
import com.sai.backend.repository.EmployeeRepository;
import com.sai.backend.service.IEmployeeService;
import com.sai.backend.util.AppUtility;
import com.sai.backend.viewobject.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeVO> getAllEmployees() {
        final List<EmployeeVO> employeeVOs = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();
        if (employees != null) {
            employees.forEach(new Consumer<Employee>() {
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

    public Integer updateEmployee(final EmployeeVO employeeVO) {
        Employee employee = AppUtility.copyFrom(employeeVO);
        Employee employeeSaved = employeeRepository.save(employee);
        return employeeSaved.getEmployeeId();
    }

    public EmployeeVO getEmployeeById(final Integer employeeId) {
        return AppUtility.copyFrom(employeeRepository.findByEmployeeId(employeeId));
    }

    public void deleteEmployee(final Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
