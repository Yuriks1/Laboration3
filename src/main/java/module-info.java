module se.iths.laboration3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires mockito.all;

    opens se.iths.laboration3 to javafx.fxml;
    exports se.iths.laboration3;
    exports se.iths.laboration3.shapes;
    opens se.iths.laboration3.shapes to javafx.fxml;
}