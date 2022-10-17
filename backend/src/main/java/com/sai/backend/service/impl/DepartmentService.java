package com.sai.backend.service.impl;

import com.sai.backend.entity.Department;

import com.sai.backend.exceptions.AppException;
import com.sai.backend.repository.DepartmentPagingRepository;
import com.sai.backend.repository.DepartmentRepository;
import com.sai.backend.service.IDepartmentService;
import com.sai.backend.util.AppUtility;
import com.sai.backend.viewobject.DepartmentVO;

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
public class DepartmentService implements IDepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentPagingRepository departmentPagingRepository;

    @Override
    public List<DepartmentVO> getAllDepartment(int page, int size) {
        log.debug("DepartmentService: getAllDepartment: Fetching department for page: "+page+" , size: "+size);
        final List<DepartmentVO> departmentVOS = new ArrayList<>();

        Pageable pageable = PageRequest.of(page, size);

        Iterable<Department> departmentIterable = departmentPagingRepository.findAll(pageable);
        if (departmentIterable != null) {
            departmentIterable.forEach(new Consumer<Department>() {
                @Override
                public void accept(Department department) {
                    departmentVOS.add(new DepartmentVO(department));
                }
            });
        }
        return departmentVOS;
    }

    @Override
    public DepartmentVO saveDepartment(DepartmentVO departmentVO) {
        Department department = AppUtility.copyFrom(departmentVO);
        department.setDepartmentId(null);
        Department departmentSaved = departmentRepository.save(department);

        DepartmentVO departmentVOSaved = AppUtility.copyFrom(departmentSaved);
        return departmentVOSaved;
    }

    @Override
    public DepartmentVO updateDepartment(DepartmentVO departmentVO) {
        Department department = AppUtility.copyFrom(departmentVO);
        if(departmentRepository.existsById(departmentVO.getDepartmentId())){
            Department departmentSaved = departmentRepository.save(department);
            DepartmentVO departmentVOSaved = AppUtility.copyFrom(departmentSaved);
            return departmentVOSaved;
        }else{
            return null;
        }
    }

    @Override
    public void deleteDepartment(Integer departmentId) throws AppException {
        try{
            departmentRepository.deleteById(departmentId);
        }catch(EmptyResultDataAccessException emptyResultDataAccessException){
            throw new AppException();
        }

    }

    public DepartmentVO getDepartmentById(final Integer departmentId) {
        return AppUtility.copyFrom(departmentRepository.findByDepartmentId(departmentId));
    }
}
