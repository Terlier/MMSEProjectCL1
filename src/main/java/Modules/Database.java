package main.java.Modules;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, String> registeredUsers  = new HashMap<String, String>() {{
        put("Justas", "ref01");
        put("Paulin", "ref02");
        put("SEP", "ref03");
    }};

    public Map<String, String> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(Map<String, String> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public String getRegisterDate(String result) {
        switch (result) {
            case "SEP":
                return "2019/07/01";
            case "Paulins":
                return "2019/05/05";
            case "Justas":
                return "2017/01/01";
            default:
                return "2015/01/01";
        }
    }
}