package testRunner;

import config.Setup;
import controllers.TransactionController;
import models.UserModel;
import org.testng.annotations.Test;

import java.io.IOException;

public class TransactionTestRunner extends Setup {

    @Test(priority = 1, description = "System deposit to an Agent")
    public void depositToAgent() throws IOException {
        TransactionController transactionController = new TransactionController();
        //user model initialize to set deposit info
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        UserModel userModel = new UserModel();
        userModel.setFrom_account("System");
        userModel.setTo_account(agentPhoneNumber);
        userModel.setAmount(2000);

        transactionController.depositToAgent(userModel);
    }

    @Test(priority = 2 , description = "Agent deposit to a Customer")
    public void depositToCustomerByAgent() throws IOException {
        TransactionController transactionController = new TransactionController();
        //user model to initialize deposit info
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        String customerPhoneNumber = prop.getProperty("first_customer_phone_number");
        UserModel userModel = new UserModel();
        userModel.setFrom_account(agentPhoneNumber);
        userModel.setTo_account(customerPhoneNumber);
        userModel.setAmount(1500);

        transactionController.depositToCustomerByAgent(userModel);
    }

    @Test(priority = 3 , description = "Withdraw money by a Customer" )
    public void withdrawByCustomer() throws IOException {
        TransactionController transactionController = new TransactionController();
        //user model to initialize withdraw info
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        String customerPhoneNumber = prop.getProperty("first_customer_phone_number");
        UserModel userModel = new UserModel();
        userModel.setFrom_account(customerPhoneNumber);
        userModel.setTo_account(agentPhoneNumber);
        userModel.setAmount(500);

        transactionController.withdrawByCustomer(userModel);
    }

    @Test(priority = 4 , description = "Agent deposit to a another Customer" )
    public void depositToAnotherCustomerByAgent() throws IOException {
        TransactionController transactionController = new TransactionController();
        //user model to initialize deposit info
        String agentPhoneNumber = prop.getProperty("agent_phone_number");
        String customerPhoneNumber = prop.getProperty("second_customer_phone_number");
        UserModel userModel = new UserModel();
        userModel.setFrom_account(agentPhoneNumber);
        userModel.setTo_account(customerPhoneNumber);
        userModel.setAmount(500);

        transactionController.depositToCustomerByAgent(userModel);
    }
    @Test(priority = 5 , description = "Customer payment to a Merchant" )
    public void paymentByCustomerToMerchant() throws IOException {
        TransactionController transactionController = new TransactionController();
        //user model to initialize deposit info
        String customerPhoneNumber = prop.getProperty("first_customer_phone_number");
        String merchantPhoneNumber = prop.getProperty("merchant_phone_number");
        UserModel userModel = new UserModel();
        userModel.setFrom_account(customerPhoneNumber);
        userModel.setTo_account(merchantPhoneNumber);
        userModel.setAmount(100);

        transactionController.paymentByCustomerToMerchant(userModel);
    }

    @Test(priority = 5 , description = "Check balance by Customer" )
    public void checkBalanceOfCustomer() throws IOException {
        TransactionController transactionController = new TransactionController();
        transactionController.checkBalanceOfCustomer();
    }

}
