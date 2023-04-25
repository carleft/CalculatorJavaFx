package com.tb.calculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    private Stage currentStage;
    private StringBuilder screenText;

    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button buttonDot;
    @FXML
    private Button buttonEql;
    @FXML
    private Button buttonPlus;
    @FXML
    private Button buttonSub;
    @FXML
    private Button buttonMul;
    @FXML
    private Button buttonDiv;
    @FXML
    private Button buttonClear;
    @FXML
    private Button buttonDel;
    @FXML
    private Label labelScreenText;
    @FXML
    private Label labelEquation;



    public void setCurrentStage(Stage stage) {
        currentStage = stage;
    }

    @FXML
    public void onEqualClick() {
        labelEquation.setText(screenText.toString() + "=");
        BigDecimal result = CalculatorCore.evaluate(screenText.toString());
        screenText.setLength(0);
        screenText.append(result);
        updateText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        screenText = new StringBuilder();

        button0.setOnAction(event -> {
            screenText.append("0");
            updateText();
        });

        button1.setOnAction(event -> {
            screenText.append("1");
            updateText();
        });

        button2.setOnAction(event -> {
            screenText.append("2");
            updateText();
        });

        button3.setOnAction(event -> {
            screenText.append("3");
            updateText();
        });

        button4.setOnAction(event -> {
            screenText.append("4");
            updateText();
        });

        button5.setOnAction(event -> {
            screenText.append("5");
            updateText();
        });

        button6.setOnAction(event -> {
            screenText.append("6");
            updateText();
        });

        button7.setOnAction(event -> {
            screenText.append("7");
            updateText();
        });

        button8.setOnAction(event -> {
            screenText.append("8");
            updateText();
        });

        button9.setOnAction(event -> {
            screenText.append("9");
            updateText();
        });

        buttonDot.setOnAction(event -> {
            screenText.append(".");
            updateText();
        });

        buttonPlus.setOnAction(event -> {
            screenText.append("+");
            updateText();
        });

        buttonSub.setOnAction(event -> {
            screenText.append("-");
            updateText();
        });

        buttonMul.setOnAction(event -> {
            screenText.append("*");
            updateText();
        });

        buttonDiv.setOnAction(event -> {
            screenText.append("/");
            updateText();
        });

        buttonClear.setOnAction(event -> {
            screenText.setLength(0);
            labelEquation.setText("");
            updateText();
        });

        buttonDel.setOnAction(event -> {
            screenText.setLength(screenText.length() - 1);
            updateText();
        });
    }

    private void updateText() {
        labelScreenText.setText(screenText.toString());
    }
}
