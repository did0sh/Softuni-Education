package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {
    public TextField firstNumberField;
    public TextField secondNumberField;
    public TextField resultField;

    public void calculate(ActionEvent actionEvent) {
        try {
            double firstNumber = Double.parseDouble(this.firstNumberField.getText());
            double secondNumber = Double.parseDouble(this.secondNumberField.getText());

            double sum = firstNumber + secondNumber;
            this.resultField.setText(String.valueOf(sum));
        } catch (Exception ex) {
            this.resultField.setText("error");
        }
    }
}
