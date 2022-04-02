package svg;

import dtos.BigEventDTO;

public class TablePlanSVG extends SVG {

    StringBuilder svg = new StringBuilder();
    int tableListSize = 0;

    public TablePlanSVG(int x, int y, String viewBox, int width, int height, BigEventDTO bigEventDTO) {
        //Starterkode til SVG
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
        tableListSize = bigEventDTO.getTablesList().size();

    }

    public void generateTable(){
        fourPeopleTable();
    }

    public void fourPeopleTable(){
        //4 people table

        addRect(50,50,100.0,150.0,svg);
        addCircle(80,30,15,svg);
        addCircle(170,30,15,svg);
        addCircle(170,170,15,svg);
        addCircle(80,170,15,svg);
    }

    public void fourPeopleTableLine(){
        //4 people table
        double tableHeight = 100.0;
        double tableWidth = 150.0;

        //

        //test 5 tables:
        int multiplyFactor = 200;
        int rowNumber = 0;
        int columnNumber = 0;
        for (int i = 0; i < tableListSize; i++) {
            if (rowNumber == 0){
            addRect(i*multiplyFactor,0,tableHeight,tableWidth,svg);
            //4 seats
            addLine(75+(multiplyFactor*i),0,75+(multiplyFactor*i), 100,svg);
            addLine((multiplyFactor*i),50,150 + (multiplyFactor*i), 50,svg);
            columnNumber++;
            if (columnNumber > 4){
                rowNumber++;
            }
            } else {

                int newI = i-5;
                addRect(newI*multiplyFactor,200,tableHeight,tableWidth,svg);
                //4 seats
                addLine(75+(multiplyFactor*newI),0+200,75+(multiplyFactor*newI), 100+200,svg);
                addLine((multiplyFactor*newI),50+200,150 + (multiplyFactor*newI), 50+200,svg);
            }
        }


    }
    public String genarateSvg(){
        //generateTable();
        fourPeopleTableLine();
        return svg + "</svg>";
    }

}
