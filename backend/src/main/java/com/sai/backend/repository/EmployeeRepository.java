package com.sai.backend.repository;

import com.sai.backend.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findByEmployeeId(Integer employeeId);

}
