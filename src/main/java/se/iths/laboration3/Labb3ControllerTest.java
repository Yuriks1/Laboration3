package se.iths.laboration3;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import se.iths.laboration3.shapes.ShapeFactory;
import static org.junit.jupiter.api.Assertions.*;

class Labb3ControllerTest {

    Labb3Controller labb3Controller = new Labb3Controller();
    Model model = labb3Controller.model;
    Shape shape = ShapeFactory.getCircle(Color.LIGHTBLUE,34.4 ,23,45);
    Shape shape2 = ShapeFactory.getSquare(Color.LIME, 4.4, 4.2, 7.7);

    @Test
    void ifWeAddAndThenDeleteTwoShapesResultShouldBeZero(){

        model.addShape(shape);
        model.addShape(shape2);
        model.undo();
        model.undo();
        var amount = model.getShapes().size();
        assertEquals(0,amount, "Result should be zero");
    }

    @Test
    void addingThreeShapesShouldReturnSizeOfThree(){

        model.addShape(shape);
        model.addShape(shape2);
        model.addShape(shape);
        var amount = model.getSize().intValue();
        assertEquals(3,amount ,"Result should be three");
    }



}