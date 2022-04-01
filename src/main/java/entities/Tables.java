package entities;

import java.util.ArrayList;
import java.util.List;


public class Tables {
    private Integer id;
    private int size;
    private String shape;

    private Event event;


    private List<Person> personList;

    public Tables(int size, String shape) {
        this.size = size;
        this.shape = shape;
        this.personList = new ArrayList<>();
    }



    public Tables() {
    }

    public void addPerson(Person person) {
        this.personList.add(person);
        if (person != null){
            person.setTables(this);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}