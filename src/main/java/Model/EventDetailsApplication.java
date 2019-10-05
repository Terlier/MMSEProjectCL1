package main.java.Model;

import java.util.Date;

public class EventDetailsApplication {
    private int recordNumber;
    private String clientName;
    private String eventType;
    private String status;
    private Date from;
    private Date to;
    private int expectedAttendees;
    private String otherPreferences;
    private int expectedBudget;

    public int getExpectedBudget() {
        return expectedBudget;
    }

    public void setExpectedBudget(int expectedBudget) {
        this.expectedBudget = expectedBudget;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getExpectedAttendees() {
        return expectedAttendees;
    }

    public void setExpectedAttendees(int expectedAttendees) {
        this.expectedAttendees = expectedAttendees;
    }

    public String getOtherPreferences() {
        return otherPreferences;
    }

    public void setOtherPreferences(String otherPreferences) {
        this.otherPreferences = otherPreferences;
    }
}
