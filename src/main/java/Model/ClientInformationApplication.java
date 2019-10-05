package main.java.Model;

import java.util.Date;

public class ClientInformationApplication {
    private int clientRecNum;
    private String name;
    private Date registrationDate;

    public int getClientRecNum() {
        return clientRecNum;
    }

    public void setClientRecNum(int clientRecNum) {
        this.clientRecNum = clientRecNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
