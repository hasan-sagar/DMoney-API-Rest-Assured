package controllers;

import config.Setup;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.UserModel;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TransactionController extends Setup {
    public TransactionController() throws IOException {
        setup();
    }

    public void depositToAgent(UserModel userModel) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response response = given().contentType("application/json").body(userModel)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when()
                .post("/transaction/deposit")
                .then().assertThat().statusCode(201).extract().response();
        System.out.println(response.asString());
    }

    public void depositToCustomerByAgent(UserModel userModel) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response response = given().contentType("application/json")
                .body(userModel)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when()
                .post("/transaction/deposit")
                .then().assertThat().statusCode(201).extract().response();
        System.out.println(response.asString());
    }

    public void withdrawByCustomer(UserModel userModel) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response response = given().contentType("application/json")
                .body(userModel)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when()
                .post("/transaction/withdraw")
                .then().assertThat().statusCode(201).extract().response();
        System.out.println(response.asString());
    }

    public void paymentByCustomerToMerchant(UserModel userModel) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response response = given().contentType("application/json")
                .body(userModel)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when()
                .post("/transaction/payment")
                .then().assertThat().statusCode(404).extract().response();
        System.out.println(response.asString());
    }

    public void checkBalanceOfCustomer() {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response response = given().contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when()
                .get("/transaction/balance/"+prop.getProperty("first_customer_phone_number"))
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
    }
}
