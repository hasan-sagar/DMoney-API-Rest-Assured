package testRunner;

import config.Utils;
import controllers.UserController;
import io.restassured.path.json.JsonPath;
import models.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


import java.io.IOException;

public class UserTestRunner {
    @Test(priority = 1, description = "Admin Login")
    public void adminDoLogin() throws IOException, ConfigurationException {
        UserController userController = new UserController();
        userController.adminDoLogin("salman@roadtocareer.net", "1234");
    }

    @Test(priority = 2, description = "Create First New customer")
    public void createNewCustomer() throws IOException, ConfigurationException {
        UserController userController = new UserController();
        //java faker for random text and data
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.name().firstName().toLowerCase() + "@test.com";
        String password = "1234";
        String phone_number = "01822" + Utils.generateRandomNumber(100000, 999999);
        String nid = "123456789";
        String role = "Customer";

        //user model object to call its constructor
        UserModel userModel = new UserModel();

        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phone_number);
        userModel.setNid(nid);
        userModel.setRole(role);

        //create new customer method call with parameter
        JsonPath jsonObj = userController.createNewCustomer(userModel);
        //set customer id
        String phoneNumber = jsonObj.get("user.phone_number");
        Utils.setEnvVar("first_customer_phone_number", phoneNumber);
    }

    @Test(priority = 3, description = "Create Second New customer")
    public void createSecondNewCustomer() throws IOException, ConfigurationException {
        UserController userController = new UserController();
        //java faker for random text and data
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.name().firstName().toLowerCase() + "@test.com";
        String password = "1234";
        String phone_number = "01822" + Utils.generateRandomNumber(100000, 999999);
        String nid = "123456789";
        String role = "Customer";

        //user model object to call its constructor
        UserModel userModel = new UserModel();

        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phone_number);
        userModel.setNid(nid);
        userModel.setRole(role);

        //create new customer method call with parameter
        JsonPath jsonObj = userController.createNewCustomer(userModel);
        //set customer id
        String phoneNumber = jsonObj.get("user.phone_number");
        Utils.setEnvVar("second_customer_phone_number", phoneNumber);
    }
    @Test(priority = 4, description = "Create Second New customer")
    public void createNewAgent() throws IOException, ConfigurationException {
        UserController userController = new UserController();
        //java faker for random text and data
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.name().firstName().toLowerCase() + "@test.com";
        String password = "1234";
        String phone_number = "01822" + Utils.generateRandomNumber(100000, 999999);
        String nid = "123456789";
        String role = "Agent";

        //user model object to call its constructor
        UserModel userModel = new UserModel();

        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phone_number);
        userModel.setNid(nid);
        userModel.setRole(role);

        //create new customer method call with parameter
        JsonPath jsonObj = userController.createNewCustomer(userModel);
        //set customer id
        String phoneNumber = jsonObj.get("user.phone_number");
        Utils.setEnvVar("agent_phone_number", phoneNumber);
    }
}
