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
        Tables tables = new Tables(4,"square");
        Person person1 = new Person("test person 1");
        Person person2 = new Person("test person 2");

        user.addEvent(event);
        event.addTable(tables);
        tables.addPerson(person1);
        tables.addPerson(person2);

        List<Tables> tablesList = new ArrayList<>();
        List<TablesDTO> tablesListDTO = new ArrayList<>();
        tablesList.add(tables);

        for (Tables tables1 : tablesList) {
            tablesListDTO.add(new TablesDTO(tables1));
        }

        BigEventDTO bigEventDTO = new BigEventDTO(event,tablesListDTO);
        System.out.println(bigEventDTO);

        String svgString = tablesPlanAsSvg(bigEventDTO);
        System.out.println(svgString);
    }

    public static String tablesPlanAsSvg(BigEventDTO bigEventDTO){
        Locale.setDefault(new Locale("US")); //laver , om til . (svg arbejder ik med punktum )
        TablePlanSVG tablePlanSVG = new TablePlanSVG(0,0, "0 0 1000 900",150,100, bigEventDTO);
        String svg = tablePlanSVG.genarateSvg();
        return svg;
    }
}
