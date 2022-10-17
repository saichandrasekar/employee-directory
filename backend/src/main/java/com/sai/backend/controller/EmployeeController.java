package com.sai.backend.controller;

import com.sai.backend.BackendApplication;
import com.sai.backend.exceptions.AppException;
import com.sai.backend.service.IEmployeeService;
import com.sai.backend.viewobject.DepartmentVO;
import com.sai.backend.viewobject.EmployeeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/backend/v1/employee/page/{page}/size/{size}")
    public ResponseEntity<List<EmployeeVO>> getAllEmployees(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        log.debug("EmployeeController: getAllEmployees: Fetching employees for page: " + page + " , size: " + size);
        size = size == 0 ? 4 : size;
        size = size > 50 ? 50 : size;

        page = page < 0 ? 0 : page;

        List<EmployeeVO> employeeVOS = employeeService.getAllEmployees(page, size);
        ResponseEntity<List<EmployeeVO>> responseEntity = employeeVOS == null || employeeVOS.isEmpty() ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(employeeVOS, HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("/backend/v1/employee/{employeeId}")
    public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
        log.debug("EmployeeController: getEmployeeById: Fetching employees for employeeId: " + employeeId);

        EmployeeVO employeeVO = employeeService.getEmployeeById(employeeId);
        ResponseEntity<EmployeeVO> responseEntity = employeeVO == null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(employeeVO, HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping("/backend/v1/employee")
    public ResponseEntity<EmployeeVO> insertEmployee(@Valid final @RequestBody EmployeeVO employeeVO) {
        EmployeeVO savedEmployeeVO = employeeService.saveEmployee(employeeVO);
        return new ResponseEntity<>(savedEmployeeVO, HttpStatus.CREATED);
    }

    @PutMapping("/backend/v1/employee")
    public ResponseEntity<EmployeeVO> updateEmployee(@Valid final @RequestBody EmployeeVO employeeVO) {
        EmployeeVO savedEmployeeVO = employeeService.updateEmployee(employeeVO);
        ResponseEntity<EmployeeVO> responseEntity = savedEmployeeVO==null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) :new ResponseEntity<>(savedEmployeeVO, HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @DeleteMapping("/backend/v1/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(final @PathVariable("employeeId") Integer employeeId) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        try {
            employeeService.deleteEmployee(employeeId);
        } catch (AppException e) {
            responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
