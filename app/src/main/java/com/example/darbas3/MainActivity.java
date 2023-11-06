package com.example.darbas3;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private Calculator calculator;
    private TextView textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = findViewById(R.id.textInput);
        calculator = new Calculator();
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        String digit = button.getText().toString();
        calculator.appendDigit(Integer.parseInt(digit));
        updateUI();
    }

    public void onDecimalPointClick(View view) {
        calculator.appendDecimalPoint();
        updateUI();
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        String newOperator = button.getText().toString();
        calculator.setOperator(newOperator);
        updateUI();
    }

    public void onEqualClick(View view) {
        calculator.calculate();
        calculator.setCurrentValue(Double.parseDouble(calculator.getCurrentInput())); // Update the currentValue
        updateUI();
        calculator.resetOperator();
    }

    public void onClearClick(View view) {
        calculator.clear();
        updateUI();
    }

    public void onClearEntryClick(View view) {
        calculator.clearEntry();
        updateUI();
    }

    public void onToggleSignClick(View view) {
        calculator.toggleSign();
        updateUI();
    }

    public void onSquareRootClick(View view) {
        calculator.calculateSquareRoot();
        updateUI();
    }

    private void updateUI() {
        String inputText = calculator.getCurrentInput();
        textInput.setText(inputText);
    }

}