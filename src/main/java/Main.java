package main.java;

import main.java.Modules.Database;
import main.java.Modules.Login;
import main.java.Model.Users;
import main.java.Modules.CustomerServiceModule;

public class Main {

    public static void main(String[] args) {
        Login login = new Login();
        Users user = login.login();

        switch (user){
            case CustomerService:
                CustomerServiceModule customerServiceView = new CustomerServiceModule();
                try {
                    customerServiceView.run();
                } catch (Exception e) {}

            default:
                break;

        }
    }
}
