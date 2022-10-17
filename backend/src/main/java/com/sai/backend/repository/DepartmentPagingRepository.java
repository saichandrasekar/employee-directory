package com.sai.backend.repository;

import com.sai.backend.entity.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentPagingRepository extends PagingAndSortingRepository<Department, Integer> {


}
