package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String userPass;



    private String address;
    private int phone;
    private String email;
    private int birthYear;
    private double balance;


    private List<Event> eventList = new ArrayList<>();



    public User() {
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserName() {
        return userName;
    }



    public User(String userName, String userPass) {
        this.userName = userName;

        this.userPass = userPass;
    }

    public void addEvent(Event event) {
        if (event != null) {
            event.setUser(this);
            this.eventList.add(event);
        }
    }



}
