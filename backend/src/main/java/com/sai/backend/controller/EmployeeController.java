package com.sai.backend.controller;

import com.sai.backend.BackendApplication;
import com.sai.backend.service.IEmployeeService;
import com.sai.backend.viewobject.EmployeeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/backend/v1/employee/page/{page}/size/{size}")
    public List<EmployeeVO> getAllEmployees(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        log.debug("EmployeeController: getAllEmployees: Fetching employees for page: " + page + " , size: " + size);
        size = size == 0 ? 4 : size;
        size = size > 50 ? 50 : size;

        page = page < 0 ? 0 : page;
        return employeeService.getAllEmployees(page, size);
    }

    @GetMapping("/backend/v1/employee/{employeeId}")
    public EmployeeVO getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
        log.debug("EmployeeController: getEmployeeById: Fetching employees for employeeId: " + employeeId);
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/backend/v1/employee")
    public @ResponseBody EmployeeVO insertEmployee(final @RequestBody EmployeeVO employeeVO) {
        EmployeeVO savedEmployeeVO = employeeService.saveEmployee(employeeVO);
        return savedEmployeeVO;
    }

    @PutMapping("/backend/v1/employee")
    public @ResponseBody EmployeeVO updateEmployee(final @RequestBody EmployeeVO employeeVO) {
        EmployeeVO savedEmployeeVO = employeeService.updateEmployee(employeeVO);
        return savedEmployeeVO;
    }

    @DeleteMapping("/backend/v1/employee/{employeeId}")
    public void deleteEmployeeById(final @PathVariable("employeeId") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }

}
