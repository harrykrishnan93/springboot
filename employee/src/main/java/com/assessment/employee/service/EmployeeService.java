package com.assessment.employee.service;

import com.assessment.employee.constants.ServiceConstants;
import com.assessment.employee.dao.EmployeeDao;
import com.assessment.employee.dao.model.Employee;
import com.assessment.employee.model.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public Employee getEmployee(long empId) {
        return employeeDao.getEmployee(empId);
    }

    @Transactional
    public ResponseDto deleteEmployee(long empId) {
        ResponseDto responseDto = new ResponseDto();
        employeeDao.deleteEmployee(empId);
        responseDto.setCode(ServiceConstants.REQUEST_SUCCESS_CODE);
        responseDto.setMessage(ServiceConstants.REQUEST_SUCCESS_MESSAGE);
        return responseDto;
    }
    @Transactional
    public ResponseDto addEmployee(Employee employee) {
        ResponseDto responseDto = new ResponseDto();
        employeeDao.addEmployee(employee);
        responseDto.setCode(ServiceConstants.REQUEST_SUCCESS_CODE);
        responseDto.setMessage(ServiceConstants.REQUEST_SUCCESS_MESSAGE);
        return responseDto;
    }

    @Transactional
    public ResponseDto updateEmployee(Employee employee) {
        ResponseDto responseDto = new ResponseDto();
        employeeDao.updateEmployee(employee);
        responseDto.setCode(ServiceConstants.REQUEST_SUCCESS_CODE);
        responseDto.setMessage(ServiceConstants.REQUEST_SUCCESS_MESSAGE);
        return responseDto;
    }
}
