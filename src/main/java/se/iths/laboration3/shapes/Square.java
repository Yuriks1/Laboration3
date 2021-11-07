package se.iths.laboration3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.laboration3.Shape;

public class Square extends Shape {

    public Square(Color color, double size, double x, double y) {
        super(color, size, x, y);
    }



    @Override
    public void draw(GraphicsContext gc) {
        double halfSize = this.getSize() / 2;
        gc.setFill(this.getColor());
        gc.fillRect(this.getX() - halfSize, this.getY() - halfSize, this.getSize(), this.getSize());
    }
    @Override
    public String getAsSvg() {
        String color = "#" + getColor().toString().subSequence(2,10);

        return  "<" + "rect" + " x=\"" + getX() + "\"" + " y=\"" + getY() + "\""
                + " width=\"" + getSize() + "\"" + " height=\"" + getSize() + "\""
                + " fill=\"" + color + "\"" + " />";
    }
}