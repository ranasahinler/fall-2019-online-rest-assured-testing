package com.automation.tests.Murodil;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
//import static io.Restassured.*;
//import static org.junit.Assert.*;


public class HRApiTests {
    String allpegionsapi="";

    @Test
    public void getAllRegionsTest(){

        Response response= RestAssured.get(allpegionsapi);  //it returns response object
        System.out.println(response.statusCode());
        System.out.println(response.getContentType());
        response.prettyPrint();
        response.body().prettyPrint();  //we can add body too

       // Assert: static olarak import edince Asseert class adini yazmamiza gerek kalmadi
        //assertEquals(200,response.statusCode());
        //assertEquals("application/json",response.contentType());
        //assertTrue(response.body().asString.contains("Americas"));
        //assertTrue(response.body().asString.contains("europe"));  //we can merge them too with &&


        //API is only get request and get response
    }
}
