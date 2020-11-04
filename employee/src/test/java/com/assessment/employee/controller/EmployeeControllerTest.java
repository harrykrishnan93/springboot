package com.assessment.employee.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static final String TOKEN_ADMIN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsInNjb3BlcyI6IlJPTEVfQURNSU4iLCJpYXQiOjE2MDQ0NTk0ODMsImV4cCI6MTYwNDQ3NzQ4M30.uGFOxbhxAluPz7DXoJTjMtD_ibVrsu8yB8gt6yzpzos";


    @Test
    public void testSearchEmployee() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", TOKEN_ADMIN);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/searchEmployee/2").accept(
                MediaType.APPLICATION_JSON).headers(httpHeaders);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse()
                .getContentAsString());

        String expected = "{\"id\":2,\"firstName\":\"Jhon\",\"lastName\":\"Joseph\",\"mobile\":\"8144156266\",\"emailId\":\"jhon.joseph@xyz.com\",\"designation\":\".Net Developer\",\"address\":{\"empId\":2,\"street\":\"Saravanampatti\",\"city\":\"Coimbatore\",\"state\":\"Tamilnadu\",\"country\":\"India\"},\"assetList\":[]}";


        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void testUpdateEmployee() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", TOKEN_ADMIN);
        String body = "{ \"id\" : \"2\", \"firstName\": \"Jhon\", \"lastName\": \"Joseph\", \"mobile\": \"8144156266\", \"designation\": \".Net Developer\", \"emailId\": \"jhon.joseph@xyz.com\" }";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                "/updateEmployee/").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"code\":\"200\",\"message\":\"Request completed sucessfully\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void testUpdateEmployeePatch() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", TOKEN_ADMIN);
        String body = "{ \"id\" : \"2\", \"firstName\": \"Jhon\", \"lastName\": \"Joseph\", \"mobile\": \"8144156266\", \"designation\": \".Net Developer\", \"emailId\": \"jhon.joseph@xyz.com\" }";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.patch(
                "/updateEmployee/").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"code\":\"200\",\"message\":\"Request completed sucessfully\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void testAddEmployee() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", TOKEN_ADMIN);
        String body = "{ \"id\" : \"2\", \"firstName\": \"Jhon\", \"lastName\": \"Joseph\", \"mobile\": \"8144156266\", \"designation\": \".Net Developer\", \"emailId\": \"jhon.joseph@xyz.com\" }";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
                "/addEmployee/").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"code\":\"403\",\"message\":\"Data Already Exists\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void deleteEmployee() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", TOKEN_ADMIN);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/deleteEmployee/1").accept(
                MediaType.APPLICATION_JSON).headers(httpHeaders);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"code\":\"200\",\"message\":\"Request completed sucessfully\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

}
