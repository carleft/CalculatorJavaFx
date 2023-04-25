package com.tb.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
    //JavaFX 应用程序中的 start()、main() 和 launch() 方法是三个重要的方法，
    //它们的调用顺序为 main() -> launch() -> Application 构造方法 -> start()

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(CalculatorApplication.class.getResource("calculator.fxml"));
        Scene scene = new Scene(loader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();

        CalculatorController controller = loader.getController();
        controller.setCurrentStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
