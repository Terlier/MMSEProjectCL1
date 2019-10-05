package main.java.Modules;

import main.java.Model.Users;

import java.util.Scanner;

public class Login {
    private String username;
    private String password;

    public Users login(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please login (CustomerService)");
        System.out.print("username: ");
        username = scan.next();
        System.out.print("password: ");
        scan.next();

        //clear console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        switch (username){
            case "FinancialManager":
                System.out.println("Logged in as Financial Manager");
                return Users.FinancialManager;
            case "CustomerService":
                System.out.println("Logged in as Customer Service");
                return Users.CustomerService;
            case "SeniorCustomerService":
                System.out.println("Logged in as Senior Customer Service");
                return Users.SeniorCustomerService;
            case "AdministrationManager":
                System.out.println("Logged in as Administration Manager");
                return Users.AdministrationManager;
            case "ServiceManager":
                System.out.println("Logged in as Service Manager");
                return Users.ServiceManager;
            case "ProductionManager":
                System.out.println("Logged in as Production Manager");
                return Users.ProductionManager;
            case "SubTeam":
                System.out.println("Logged in as Sub-team member");
                return Users.SubTeam;
            case "HR":
                System.out.println("Logged in as HR member");
                return Users.HR;

            default:
                System.out.println("Wrong login information");
                return Users.UNDEFINED;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
