import dtos.BigEventDTO;
import dtos.TablesDTO;
import entities.Event;
import entities.Person;
import entities.Tables;
import entities.User;
import svg.TablePlanSVG;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        User user = new User("user","test1");
        Event event = new Event(user,"event description","event title","event time");
        Tables tables1 = new Tables(4,"square");
        Tables tables2 = new Tables(4,"square");
        Tables tables3 = new Tables(4,"square");
        Tables tables4 = new Tables(4,"square");
        Tables tables5 = new Tables(4,"square");
        Tables tables6 = new Tables(4,"square");
        Tables tables7 = new Tables(4,"square");
        Tables tables8 = new Tables(4,"square");
        Tables tables9 = new Tables(2,"square");
        Tables tables10 = new Tables(2,"square");
        Tables tables11 = new Tables(2,"square");
        Tables tables12 = new Tables(4,"square");

        Person person1 = new Person("test person 1");
        Person person2 = new Person("test person 2");
        Person person3 = new Person("bo");

        user.addEvent(event);
        event.addTable(tables1);
        tables1.addPerson(person1);
        tables1.addPerson(person2);
        tables1.addPerson(person3);
        tables10.addPerson(person3);

        List<Tables> tablesList = new ArrayList<>();
        List<TablesDTO> tablesListDTO = new ArrayList<>();
        tablesList.add(tables1);
        tablesList.add(tables2);
        tablesList.add(tables3);
        tablesList.add(tables4);
        tablesList.add(tables5);
        tablesList.add(tables6);
        tablesList.add(tables7);
        tablesList.add(tables8);
        tablesList.add(tables9);
        tablesList.add(tables10);
        tablesList.add(tables11);
        tablesList.add(tables12);

        for (Tables t : tablesList) {
            tablesListDTO.add(new TablesDTO(t));
        }

        BigEventDTO bigEventDTO = new BigEventDTO(event,tablesListDTO);
        System.out.println(bigEventDTO);

        String svgString = tablesPlanAsSvg(bigEventDTO);
        System.out.println(svgString);
    }

    public static String tablesPlanAsSvg(BigEventDTO bigEventDTO){
        Locale.setDefault(new Locale("US")); //laver , om til . (svg arbejder ik med komma )
        TablePlanSVG tablePlanSVG = new TablePlanSVG(0,0, "0 0 1000 900",100,100, bigEventDTO);
        String svg = tablePlanSVG.genarateSvg();
        return svg;
    }
}
