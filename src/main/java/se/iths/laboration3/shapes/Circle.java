package se.iths.laboration3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.laboration3.Shape;

public class Circle extends Shape {

    public Circle(Color color, double size, double x, double y) {
        super(color, size, x, y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        double r = getSize() / 2;
        gc.setFill(this.getColor());
        gc.fillOval(this.getX() - r, this.getY() - r, this.getSize(), this.getSize());
    }
    @Override
    public String getAsSvg() {
        String color = "#" + getColor().toString().subSequence(2,10);

        return "<" + "circle" + " cx=\"" + getX() + "\"" + " cy=\"" + getY() + "\""
                + " r=\"" + getSize() / 2 + "\"" + " fill=\"" + color + "\"" + " />";
    }
}