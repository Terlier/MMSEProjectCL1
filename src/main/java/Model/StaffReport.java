package main.java.Model;

public class StaffReport {
    private StaffMemberInformation employee;
    private String availableEmployees;

    public StaffMemberInformation getEmployee() {
        return employee;
    }

    public void setEmployee(StaffMemberInformation employee) {
        this.employee = employee;
    }

    public String getAvailableEmployees() {
        return availableEmployees;
    }

    public void setAvailableEmployees(String availableEmployees) {
        this.availableEmployees = availableEmployees;
    }
}
