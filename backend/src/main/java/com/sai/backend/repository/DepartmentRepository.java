package com.sai.backend.repository;

import com.sai.backend.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    Department findByDepartmentId(Integer departmentId);
}
