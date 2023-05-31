package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class APIexamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUwNTg1NDYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTEwMTc0NiwidXNlcklkIjoiNTMxNiJ9.M5eKsdrw-o-mn6HWHwrS0vq1nSYO593q6ouhq2W6-YM";
    @Test
    public void createANEmployee(){

       RequestSpecification preparedRequest =given().header("Content-Type", "appllication/json")
                .header("Authorization",token)
                .body("{\n" +
                "  \"emp_firstname\": \"andyc\",\n" +
                "  \"emp_lastname\": \"wilson\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1992-05-20\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"Engineer\"\n" +
                "}");

        // what is the variable that holds all the request specification
       // act as a send key
        // prepared requesy ==> attached all the data for the request
       Response response= preparedRequest.when().post("/createEmployee.php");

        response.prettyPrint();


    }





}
