package com.assessment.employee.constants;

public final class ServiceConstants {
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "hash-key";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String EMPLOYEE_ID_MANDATORY_MESSAGE = "Employee Id is mandatory.";
    public static final String FIRST_NAME_MANDATORY_MESSAGE = "First Name is mandatory.";
    public static final String LAST_NAME_MANDATORY_MESSAGE = "Last Name is mandatory.";
    public static final String MOBILE_NO_MANDATORY_MESSAGE = "Mobile number Birth is mandatory.";
    public static final String MOBILE_NO_INVALID_MESSAGE = "Invalid mobile number.";
    public static final String EMAIL_MANDATORY_MESSAGE = "Email Id is mandatory.";
    public static final String DESIGNATION_MANDATORY_MESSAGE = "Designation is mandatory.";
    public static final String URL_NOT_FOUND_MESSAGE = "The URL you have reached is not in service at this time (404).";
    public static final String REQUEST_BAD_CODE = "400";
    public static final String REQUEST_SUCCESS_CODE = "200";
    public static final String REQUEST_SUCCESS_MESSAGE = "Request completed sucessfully";
    public static final String DATA_NOT_FOUND_CODE = "404";
    public static final String DATA_NOT_FOUND_MESSAGE = "Data not found";
    public static final String DATA_ALREADY_EXISTS_CODE = "403";
    public static final String DATA_ALREADY_EXISTS_MESSAGE = "Data Already Exists";
}
