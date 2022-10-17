package com.sai.backend.repository;

import com.sai.backend.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface EmployeePagingRepository extends PagingAndSortingRepository<Employee, Integer> {


}
