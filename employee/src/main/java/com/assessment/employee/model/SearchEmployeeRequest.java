package com.assessment.employee.model;

import java.io.Serializable;

public class SearchEmployeeRequest implements Serializable {

    private static final long serialVersionUID = -2606424899548718117L;

    private long employeeId;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}