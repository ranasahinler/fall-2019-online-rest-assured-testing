package com.automation.tests.day3;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*; //static olarak import ettik ki durmadan yazmak zorunda kalmayalim
import static org.junit.jupiter.api.Assertions.*; //static olarak import ettik ki durmadan yazmak zorunda kalmayalim
import static org.hamcrest.Matchers.*;  //import ettikki used for advance assertions

public class ORDSTestDay3 {

    @BeforeAll
    public static void setup(){
        baseURI= "http://54.224.118.38:1000/ords/hr";
    }

    @Test
    public void verifyFirstRegion() {
        given().pathParam("id", 1).
                when().get("/regions/{id}").prettyPeek().
                then().assertThat().statusCode(200).
                and().body("region_name", is("Europe")).
                body("region_id", is(1)).
                time(lessThan(5L), TimeUnit.SECONDS); //verify that response time is less than 5 seconds
    }
        @Test
        public void verifyEmployee(){
        Response response = given().accept(ContentType.JSON).
                             when().get("/employees");

            JsonPath jsonPath = response.jsonPath();

            String nameOfLastEmployee=jsonPath.getString("items[-1].first_name"); //gpath syntax olunca son employee icin -1 koyabiliyorsun
            String nameOf1BeforeLastEmployee=jsonPath.getString("items[-2].first_name");
            String nameOfFirstEmployee =jsonPath.getString("items[0].first_name");

            System.out.println(nameOfFirstEmployee);
            System.out.println(nameOfLastEmployee);
            System.out.println(nameOf1BeforeLastEmployee);


            Map<String,Object>firstEmployee= jsonPath.get("item[0]");


        }
    }

