package com.assessment.employee.controller;

import com.assessment.employee.constants.ServiceConstants;
import com.assessment.employee.dao.model.Employee;
import com.assessment.employee.service.EmployeeService;
import com.assessment.employee.model.DeleteEmployeeRequest;
import com.assessment.employee.model.ResponseDto;
import com.assessment.employee.model.SearchEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PreAuthorize("hasRole('" + ServiceConstants.ROLE_USER + "')" +
            " || hasRole('" + ServiceConstants.ROLE_ADMIN + "')" )
    @RequestMapping(value = "/searchEmployee/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@Valid SearchEmployeeRequest searchEmployeeRequest) {
        Employee employee = employeeService.getEmployee(searchEmployeeRequest.getEmployeeId());
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('" + ServiceConstants.ROLE_ADMIN + "')")
    @RequestMapping(value = "/addEmployee", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDto> addEmployee(@RequestBody @Valid Employee employee) {
        ResponseDto responseDto = employeeService.addEmployee(employee);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('" + ServiceConstants.ROLE_ADMIN + "')")
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> updateEmployee(@RequestBody @Valid Employee employee) {
        ResponseDto responseDto = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('" + ServiceConstants.ROLE_ADMIN + "')")
    @RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseDto> deleteEmployee(@Valid DeleteEmployeeRequest deleteEmployeeRequest) {
        ResponseDto responseDto = employeeService.deleteEmployee(deleteEmployeeRequest.getEmployeeId());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('" + ServiceConstants.ROLE_ADMIN + "')")
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PATCH)
    public ResponseEntity<ResponseDto> patchEmployee(@RequestBody @Valid Employee employee) {
        ResponseDto responseDto = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
