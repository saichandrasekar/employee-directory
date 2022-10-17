package com.sai.backend.controller;

import com.sai.backend.service.IDepartmentService;

import com.sai.backend.viewobject.DepartmentVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/backend/v1/department/page/{page}/size/{size}")
    public List<DepartmentVO> getAllEmployees(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        log.debug("EmployeeController: getAllEmployees: Fetching employees for page: " + page + " , size: " + size);
        size = size == 0 ? 4 : size;
        size = size > 50 ? 50 : size;

        page = page < 0 ? 0 : page;
        return departmentService.getAllDepartment(page, size);
    }

    @GetMapping("/backend/v1/department/{departmentId}")
    public DepartmentVO getEmployeeById(@PathVariable("departmentId") Integer departmentId) {
        log.debug("EmployeeController: getEmployeeById: Fetching employees for departmentId: " + departmentId);
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping("/backend/v1/department")
    public @ResponseBody DepartmentVO insertEmployee(final @RequestBody DepartmentVO departmentVO) {
        DepartmentVO saveDepartmentVO = departmentService.saveDepartment(departmentVO);
        return saveDepartmentVO;
    }

    @PutMapping("/backend/v1/department")
    public @ResponseBody DepartmentVO updateEmployee(final @RequestBody DepartmentVO departmentVO) {
        DepartmentVO saveDepartmentVO = departmentService.updateDepartment(departmentVO);
        return saveDepartmentVO;
    }

    @DeleteMapping("/backend/v1/department/{departmentId}")
    public void deleteEmployeeById(final @PathVariable("departmentId") Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
    }

}
