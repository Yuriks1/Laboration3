package se.iths.laboration3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import se.iths.laboration3.shapes.ShapeFactory;


public class Labb3Controller{

    @FXML
    public ComboBox<ShapeOption> comboBox;
    @FXML
    public ResizableCanvas canvas;
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public Text sizeText;
    @FXML
    public Button undoButton;
    @FXML
    public Slider sizeSlider;
    @FXML
    public Button saveButton;
    @FXML
    public Button exitButton;


    public Model model;

    public void initialize() {

        this.model = new Model();
        model.setInitialValues(ShapeOption.Circle, Color.BLACK, 50F);
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
        sizeSlider.valueProperty().bindBidirectional(model.sizeProperty());
        comboBox.valueProperty().bindBidirectional(model.selectedShapeTypeProperty());
        canvas.widthProperty().addListener(observable -> draw());
        canvas.heightProperty().addListener(observable -> draw());
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        model.isInSelectMode();
        Shape newShape = getNewShapeBySelectedType(mouseEvent);
        model.addShape(newShape);
        draw();

    }

    public Shape getNewShapeBySelectedType(MouseEvent mouseEvent) {
        return switch (model.getSelectedShapeType()) {
            case Circle -> ShapeFactory.getCircle(model.getColor(), model.getSize(), mouseEvent.getX(), mouseEvent.getY());
            case Square -> ShapeFactory.getSquare(model.getColor(), model.getSize(), mouseEvent.getX(), mouseEvent.getY());
        };
    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (var shape : model.getShapes()) {
            shape.draw(gc);
        }
    }

    public void undoButton() {
        try {
            model.undo();
            draw();
        } catch (Exception e) {
            System.out.println("You must do something first!"); }
    }

    public void saveButton() {
        try {
            model.writeToSvg();
            System.out.println("File saved!");
        } catch (Exception e) {
            System.out.println("You did not save your file :( !");
        }
    }

    public void exitButton() {
        Platform.exit();
        System.out.println("Hasta La Vista!");
    }
}
