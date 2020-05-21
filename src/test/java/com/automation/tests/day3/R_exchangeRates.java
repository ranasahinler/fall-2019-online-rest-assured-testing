package com.automation.tests.day3;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.*; //static olarak import ettik ki durmadan yazmak zorunda kalmayalim
import static org.junit.jupiter.api.Assertions.*; //static olarak import ettik ki durmadan yazmak zorunda kalmayalim
import static org.hamcrest.Matchers.*;  //import ettikki used for advance assertions


public class R_exchangeRates {
    @BeforeAll  //must be static and void return type and no private
    public static void setup() {
        baseURI = "http://api.openrates.io";
    }

    @Test
    public void getLatestRates(){
        Response response = get("/latest").prettyPeek();   //preety peek returns response object
        response.then().assertThat().statusCode(200);
    }

    //QUERY PARAMETER: AFTER ? IT COMES

    @Test
    public void getLatestRatesWITHQUERYPARAMETER(){
        Response response = given().
                queryParam("base","USD").
                when().
                get("/latest").
                prettyPeek();   //preety peek returns response object

        Headers headers= response.getHeaders(); // to read header of the response
        String contentType= headers.getValue("Content-Type");
        System.out.println(contentType);

        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("base",is("USD")); //normalde Matchers.is("USD") olarak yazmaliydik
                                                                        // ama import ettigimiz icin sinif adini yazmadik


        String date= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));  //gives todays date

        //to make it dynamic instead of giving actual date like "2020-05-10" we give string date
        response.then().assertThat().body("date",containsString(date)); //
    }
@Test
 public void getHistoryOfRates() {
    Response response = given().queryParam("base", "USD").
            when().get("/2008-01-01").prettyPeek();

    Headers headers = response.getHeaders();

    response.then().assertThat().statusCode(200).
              and().body("date", is("2007-12-31")).
              and().body("rates.USD",is(1.0f)).
    and().body("rates.TRY",is(1.1663609809f));
    //ingridents of bread:metadata
    //bread's itself :data

    Float param = response.jsonPath().get("rates.EUR");
    System.out.println(param);


}








    }

