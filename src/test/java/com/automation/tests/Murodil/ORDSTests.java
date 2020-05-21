package com.automation.tests.Murodil;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class ORDSTests {

    String URL= "http://54.224.118.38:1000/ords/hr/";
    @Test
    public void ords() {

        Response response = RestAssured.get(URL);
        System.out.println(response.statusCode());
     //   System.out.println(response.body().asString());
        response.prettyPrint();


    }}
