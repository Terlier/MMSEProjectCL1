package main.java.Modules;

import main.java.Model.EventDetailsApplication;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CustomerServiceModule {
    public void run() throws Exception{
        Scanner scan = new Scanner(System.in);

        System.out.println("Please selection action: \n1. Create Request");
        String selection = scan.next();

        switch (selection){
            case "1":
                EventDetailsApplication eventDetailsApplication = new EventDetailsApplication();
                System.out.println("Please input client name, event type, from and to dates, expected number of attendees, select preferences and expected budget.");
                System.out.print("Client name: ");
                eventDetailsApplication.setClientName(scan.next());
                System.out.print("Event type: ");
                eventDetailsApplication.setEventType(scan.next());
                System.out.print("From: ");
                DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
                String dateString = scan.next();
                Date date = format.parse(dateString);
                eventDetailsApplication.setFrom(date);
                System.out.print("To: ");
                dateString = scan.next();
                date = format.parse(dateString);
                eventDetailsApplication.setTo(date);
                System.out.print("Expected number of attendees: ");
                eventDetailsApplication.setExpectedAttendees(scan.nextInt());
                System.out.println("Preferences (y/n): ");
                System.out.print("Decorations ");
                scan.next();
                System.out.print("Parties ");
                scan.next();
                System.out.print("Photos/filming ");
                scan.next();
                System.out.print("Expected budget: ");
                eventDetailsApplication.setExpectedBudget(scan.nextInt());
                System.out.println(createRequest(eventDetailsApplication));
                break;

            default:
                System.out.println("Wrong input");
                run();
        }
    }

    public String createRequest(EventDetailsApplication eventDetailsApplication) throws Exception {
        StringBuilder sb = new StringBuilder();
        String clientName = eventDetailsApplication.getClientName();
        Database db = new Database();
        String result = db.getRegisteredUsers().get(clientName);
        if(result == null) {
            sb.append("New client\nreference number " + "ref04" + "\n");
        }
        else {
            //check if date is at least 1 year old, otherwise junior client
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
            Date dateReg = format.parse(db.getRegisterDate(clientName));
            long diff = calculateDiff(dateReg);

            if((int)diff > 365){
                sb.append("Senior client : " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + "\nReference number " + result +"\n");
            }
            else {
                sb.append("Junior client : " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + "\nReference number " + result +"\n");
            }
        }

        if(eventDetailsApplication.getExpectedBudget() < 1000){
            return "Initial budget has to be at least 1000";
        }

        if(eventDetailsApplication.getExpectedAttendees() < 100){
            return "Expected attendees has to be at least 100";
        }

        sb.append("Event number ev114929");

        return sb.toString();
    }

    public long calculateDiff(Date dateReg) {
        Date today = new Date();
        today.setHours(0);
        return today.getTime() - dateReg.getTime();
    }
}
