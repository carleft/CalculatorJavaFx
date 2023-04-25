module com.tb.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.tb.calculator to javafx.fxml;
    exports com.tb.calculator;
}