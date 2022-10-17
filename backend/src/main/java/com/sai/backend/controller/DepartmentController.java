package com.sai.backend.controller;

import com.sai.backend.exceptions.AppException;
import com.sai.backend.service.IDepartmentService;

import com.sai.backend.viewobject.DepartmentVO;

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
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/backend/v1/department/page/{page}/size/{size}")
    public ResponseEntity<List<DepartmentVO>> getAllEmployees(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        log.debug("EmployeeController: getAllEmployees: Fetching employees for page: " + page + " , size: " + size);
        size = size == 0 ? 4 : size;
        size = size > 50 ? 50 : size;

        page = page < 0 ? 0 : page;

        List<DepartmentVO> departmentVOS = departmentService.getAllDepartment(page, size);
        ResponseEntity<List<DepartmentVO>> responseEntity = departmentVOS == null || departmentVOS.isEmpty() ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(departmentVOS, HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("/backend/v1/department/{departmentId}")
    public ResponseEntity<DepartmentVO> getEmployeeById(@PathVariable("departmentId") Integer departmentId) {
        log.debug("EmployeeController: getEmployeeById: Fetching employees for departmentId: " + departmentId);

        DepartmentVO departmentVO = departmentService.getDepartmentById(departmentId);
        ResponseEntity<DepartmentVO> responseEntity = departmentVO == null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(departmentVO, HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping("/backend/v1/department")
    public ResponseEntity<DepartmentVO> insertEmployee(@Valid final @RequestBody DepartmentVO departmentVO) {
        DepartmentVO saveDepartmentVO = departmentService.saveDepartment(departmentVO);
        return new ResponseEntity<>(saveDepartmentVO, HttpStatus.CREATED);
    }

    @PutMapping("/backend/v1/department")
    public ResponseEntity<DepartmentVO> updateEmployee(@Valid final @RequestBody DepartmentVO departmentVO) {
        DepartmentVO saveDepartmentVO = departmentService.updateDepartment(departmentVO);
        ResponseEntity<DepartmentVO> responseEntity = saveDepartmentVO==null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) :new ResponseEntity<>(saveDepartmentVO, HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @DeleteMapping("/backend/v1/department/{departmentId}")
    public ResponseEntity<String> deleteEmployeeById(final @PathVariable("departmentId") Integer departmentId) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        try {
            departmentService.deleteDepartment(departmentId);
        } catch (AppException e) {
            responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
