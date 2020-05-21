package com.automation.tests.Murodil;




import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*; //every static

import static io.restassured.RestAssured.given;

public class SpartanTests {

    //"ec2-3-87-109-5.compute-1.amazonaws.com:8000/api/spartans";

  String spartanAllURL = "http://3.90.112.152:8000";
    @Test
    public void viewAllSpartanTest() {


        given().auth().basic("admin","admin").baseUri(spartanAllURL).
                when().get("/api/spartans").prettyPeek().
                then().statusCode(200);
    }
    //murodil's solution
//  String spartanAllURL = "http://3.90.112.152:8000/api/spartans/";
//        Response response = RestAssured.get(spartanAllURL);
//        System.out.println(response.statusCode());
//        System.out.println(response.body().asString()); //json format..you dont have to write body()
//        System.out.println(response.asString());//everything is in 1 line and it doesnt look nice
//        response.prettyPrint(); //en guzel gorunus
//RestAssured:it has many ready static methods that we can call from RestAssured class
//RestAsurred.get(url)


/*
given accept type is Json
when user sends a get request to spartan url
then response status code is 200
and response body should json
and response should contain "name":"Chipotle"
 */

    @Test
    public void viewAllSpartansTst2(){

        Response response = RestAssured.
                given().  //for readabilty we use given for bdd
                accept(ContentType.JSON).  //given accept type is Json **Header part** before sending my request I prepare my header
                when().    //
                get(spartanAllURL);  //when user send get request to url,it gives response  and we collect it into response


        Assertions.assertEquals(200,response.statusCode());  //i check my status code
        Assertions.assertEquals("application/json;charset=UTF-8",response.contentType());  //after status code I verify header
        Assertions.assertTrue(response.body().asString().contains("hasan")); //response type olan json type olan response u string e cevirip iceriginde elimizde olan olmadigini soruyoruz string manuplations
Assertions.assertEquals(true,response.body().asString().contains("hasan"));

//***************we can do all of the together EASYWAY
        //REQUEST PART
//        given().accept(ContentType.JSON).
//        when().get(spartanAllURL).
//        RESPONSE PART
//        then().statusCode(200).and().contentType("application/json;charset=UTF-8");


// ContentType. is enum (list of values and we choose which one we want to use) like
        //any-text-json-xml-html-urlenc-binary

when().get("URL").
        then().statusCode(200).
        and().contentType("application/json;charset=UTF-8");
//.and().body().asString().contains("Fiole");
    }

}