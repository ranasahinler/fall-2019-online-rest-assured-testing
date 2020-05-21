package com.automation.tests.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ORDSTests {

    String BASE_URL = "http://3.90.112.152:1000/ords/hr";

    @Test
    @DisplayName("Get list of all employess")
    public void getAllEmployees(){
        Response response =
                given().
                        baseUri(BASE_URL).
                        when().get("/employees").
                        prettyPeek();
    }

    //:header of response reserve the technical information
    //HTTP/1.1 200 OK
    //Date: Sun, 17 May 2020 17:49:38 GMT
    //Content-Type: application/json
    //ETag: "xfpAm9x57e33U1Dl8yyjlpmQLl+Qna+crKCi0D3uC411jNhiCvtge/43GaRp/QDxcL8maPYmmoosDvJywG+M5A=="
    //Transfer-Encoding: chunked

// body of response
//    "items": [
//        {
//            "employee_id": 100,
//            "first_name": "Steven",
//            "last_name": "King",
//            "email": "SKING",
//            "phone_number": "515.123.4567",
//            "hire_date": "2003-06-17T04:00:00Z",
//            "job_id": "AD_PRES",
//            "salary": 24000,
//            "commission_pct": null,
//            "manager_id": null,
//            "department_id": 90,
//            "links": [
//

    @Test
    @DisplayName("get employee under soecific id")
    public void getOneEmployee(){
//in URL we can specify path and querry parameters
        Response response= given().baseUri(BASE_URL).when().get("employees/{is}",100).prettyPeek();
        response.then().statusCode(200);
        int statusCode = response.statusCode();
        Assertions.assertEquals(201,statusCode);
    }

    /**
     * given base URI = http://3.90.112.152:1000/ords/hr
     * when user sends get request to "/countries"
     * then user verifies that status code is 200
     */
            @Test
            @DisplayName("get countries")
            public void findCountries(){
    Response response=given().baseUri("http://3.90.112.152:1000/ords/hr").when().get("/countries").prettyPeek();
    response.then().statusCode(200);

}}
/*
when our test passes  we prove it from html reports ?
it depends from company to company.
pdf reports -  excel report -  html reports can be used.
HTML reports is most common way - it is easy to read easy to generate
 */