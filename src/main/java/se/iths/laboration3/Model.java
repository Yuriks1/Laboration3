package se.iths.laboration3;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import java.util.*;

public class Model {

    private final ObjectProperty<Color> color;
    private final FloatProperty size;
    private final SvgWriter svgWriter;
    private final List<Shape> shapes = new ArrayList<>();
    private final Deque<Shape> history = new ArrayDeque<>();
    private final Map<Shape, Shape> replacements = new HashMap<>();
    private final ObjectProperty<ShapeOption> selectedShapeType;
    private final BooleanProperty inSelectMode;



    public Model() {
        this.color = new SimpleObjectProperty<>();
        this.size = new SimpleFloatProperty();
        inSelectMode = new SimpleBooleanProperty();
        this.selectedShapeType = new SimpleObjectProperty<>();
        svgWriter = new SvgWriter();

    }


    public void setInitialValues(ShapeOption shape, Color color, Float size) {
        this.selectedShapeType.setValue(shape);
        this.color.setValue(color);
        this.size.setValue(size);
    }

    public ShapeOption getSelectedShapeType() {
        return selectedShapeType.getValue();
    }

    public Property<ShapeOption> selectedShapeTypeProperty() {
        return selectedShapeType;
    }

    public void isInSelectMode() {inSelectMode.getValue();}

    public List<Shape> getShapes() {
        return shapes;
    }

    public Color getColor() {
        return color.getValue();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public Float getSize() {
        return size.getValue();
    }

    public FloatProperty sizeProperty() {
        return size;
    }


    public void addShape(Shape newShape) {
        shapes.add(newShape);
        history.push(newShape);
    }

    public void undo() {
        Shape lastAddedShape = history.pop();
        shapes.remove(lastAddedShape);

        if(replacements.containsKey(lastAddedShape)) {
            shapes.add(replacements.get(lastAddedShape));
            replacements.remove(lastAddedShape);
        }else{
            System.out.println("One step back!");        }
    }

    public void writeToSvg() {
        svgWriter.save(this);
    }
}


