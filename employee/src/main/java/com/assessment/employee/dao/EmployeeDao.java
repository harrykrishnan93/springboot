package com.assessment.employee.dao;

import com.assessment.employee.dao.model.Employee;
import com.assessment.employee.dao.repository.EmployeeRepository;
import com.assessment.employee.exception.DataAlreadyExists;
import com.assessment.employee.exception.DataNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class EmployeeDao {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployee(long empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new DataNotfoundException();
        }
    }

    public void deleteEmployee(long empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if(!employee.isPresent()) {
            throw new DataNotfoundException();
        } else {
            employeeRepository.deleteById(empId);
        }
    }

    public void addEmployee(Employee emp) {
        Optional<Employee> employee = employeeRepository.findById(emp.getId());
        if(employee.isPresent()) {
            throw new DataAlreadyExists();
        } else {
            employeeRepository.save(emp);
        }
    }

    public void updateEmployee(Employee emp) {
        Optional<Employee> employee = employeeRepository.findById(emp.getId());
        if(!employee.isPresent()) {
            throw new DataNotfoundException();
        } else {
            employeeRepository.save(emp);
        }
    }
}