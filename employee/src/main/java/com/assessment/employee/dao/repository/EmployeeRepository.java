package com.assessment.employee.dao.repository;

import com.assessment.employee.dao.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findById(int id);

    @Override
    void deleteById(Long aLong);
}