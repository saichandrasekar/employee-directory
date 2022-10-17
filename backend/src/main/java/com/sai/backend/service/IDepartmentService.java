package com.sai.backend.service;

import com.sai.backend.viewobject.DepartmentVO;

import java.util.List;

public interface IDepartmentService {

    List<DepartmentVO> getAllDepartment(final int page, final int size);

    DepartmentVO saveDepartment(final DepartmentVO departmentVO);

    DepartmentVO updateDepartment(final DepartmentVO departmentVO);

    void deleteDepartment(final Integer departmentId);
}
