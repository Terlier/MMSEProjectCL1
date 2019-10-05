package test.java;

import main.java.Model.EventDetailsApplication;
import main.java.Modules.CustomerServiceModule;
import main.java.Modules.Database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InputClientRequestTest {

    @org.junit.Test
    public void SuccessfulIOldClientnputClientRequest() throws Exception {
        Database db = new Database();
        EventDetailsApplication eda = new EventDetailsApplication();
        CustomerServiceModule csm = new CustomerServiceModule();

        eda.setClientName("SEP");
        eda.setEventType("Concert");
        eda.setFrom(strToDate("2019/12/23"));
        eda.setTo(strToDate("2019/12/24"));
        eda.setExpectedAttendees(2000);
        eda.setOtherPreferences("Decorations,Parties,Photos/filming");
        eda.setExpectedBudget(2000000);

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        Date dateReg = format.parse(db.getRegisterDate(eda.getClientName()));

        assertEquals(csm.createRequest(eda),
                "Junior client : " + TimeUnit.DAYS.convert(csm.calculateDiff(dateReg), TimeUnit.MILLISECONDS) + "\n" +
                "Reference number " + db.getRegisteredUsers().get(eda.getClientName()) + "\n" +
                "Event number ev114929");
    }

    @org.junit.Test
    public void SuccessfulINewClientnputClientRequest() throws Exception {
        Database db = new Database();
        EventDetailsApplication eda = new EventDetailsApplication();
        CustomerServiceModule csm = new CustomerServiceModule();

        eda.setClientName("SEO");
        eda.setEventType("Concert");
        eda.setFrom(strToDate("2019/12/23"));
        eda.setTo(strToDate("2019/12/24"));
        eda.setExpectedAttendees(2000);
        eda.setOtherPreferences("Decorations,Parties,Photos/filming");
        eda.setExpectedBudget(2000000);

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        Date dateReg = format.parse(db.getRegisterDate(eda.getClientName()));

        assertEquals(csm.createRequest(eda),
                "New client\n" +
                        "reference number ref04\n" +
                        "Event number ev114929");
    }

    @org.junit.Test
    public void BudgetTooLowInputClientRequest() throws Exception {
        EventDetailsApplication eda = new EventDetailsApplication();
        CustomerServiceModule csm = new CustomerServiceModule();

        eda.setClientName("SEO");
        eda.setEventType("Concert");
        eda.setFrom(strToDate("2019/12/23"));
        eda.setTo(strToDate("2019/12/24"));
        eda.setExpectedAttendees(2000);
        eda.setOtherPreferences("Decorations,Parties,Photos/filming");
        eda.setExpectedBudget(20);

        assertEquals(csm.createRequest(eda),
                "Initial budget has to be at least 1000");
    }

    @org.junit.Test
    public void NotEnoughAttendeesInputClientRequest() throws Exception {
        EventDetailsApplication eda = new EventDetailsApplication();
        CustomerServiceModule csm = new CustomerServiceModule();

        eda.setClientName("SEO");
        eda.setEventType("Concert");
        eda.setFrom(strToDate("2019/12/23"));
        eda.setTo(strToDate("2019/12/24"));
        eda.setExpectedAttendees(2);
        eda.setOtherPreferences("Decorations,Parties,Photos/filming");
        eda.setExpectedBudget(20000);

        assertEquals(csm.createRequest(eda),
                "Expected attendees has to be at least 100");
    }

    public Date strToDate(String input) throws Exception{
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        return format.parse(input);
    }
}