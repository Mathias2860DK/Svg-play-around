package svg;

import dtos.BigEventDTO;

public class TablePlanSVG extends SVG {

    StringBuilder svg = new StringBuilder();

    public TablePlanSVG(int x, int y, String viewBox, int width, int height, BigEventDTO bigEventDTO) {
        //Starterkode til SVG
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));

    }

    public void generateTable(){
        addRect(50,50,200.0,200.0,svg);
    }
    public String genarateSvg(){
        generateTable();
        return svg + "</svg>";
    }

}
