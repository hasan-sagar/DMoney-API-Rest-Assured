package controllers;

import config.Setup;
import config.Utils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.UserModel;
import org.apache.commons.configuration.ConfigurationException;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserController extends Setup {
    //initialize setup in constructor
    public UserController() throws IOException {
        setup();
    }

    //admin login
    public void adminDoLogin(String email, String password) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        UserModel userModel = new UserModel();
        userModel.setEmail(email);
        userModel.setPassword(password);
        Response response = given().contentType("application/json").body(userModel)
                .when()
                .post("/user/login")
                .then()
                .assertThat().statusCode(200).extract().response();
        JsonPath jsonObj = response.jsonPath();
        String token = jsonObj.get("token");
        Utils.setEnvVar("token", token);
    }

    //create new customer
    public JsonPath createNewCustomer(UserModel userModel) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response response = given().contentType("application/json").body(userModel)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when()
                .post("/user/create")
                .then().assertThat().statusCode(201).extract().response();
        System.out.println(response.asString());
        return response.jsonPath();
    }
}
