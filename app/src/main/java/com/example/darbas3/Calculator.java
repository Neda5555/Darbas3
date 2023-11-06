package com.example.darbas3;
import java.text.DecimalFormat;

public class Calculator  {
    private double currentValue = 0;
    private String currentInput = "";
    private String operator = "";
    private boolean isResultDisplayed = false;
    private String prevOperator = ""; // Track the previous operator

    public void appendDigit(int digit) {
        if (isResultDisplayed) {
            currentInput = "";
            isResultDisplayed = false;
        }
        currentInput += digit;
    }

    public void appendDecimalPoint() {
        if (isResultDisplayed) {
            currentInput = "0.";
            isResultDisplayed = false;
        } else if (!currentInput.contains(".")) {
            currentInput += ".";
        }
    }

    public void setOperator(String newOperator) {
        if (!currentInput.isEmpty()) {
            if (!prevOperator.isEmpty()) {
                // A previous operator exists, perform calculation using the previous operator
                calculate();
                prevOperator = newOperator;  // Update the previous operator
            } else {
                prevOperator = newOperator;
                currentValue = Double.parseDouble(currentInput);
            }
            currentInput = "";
            operator = newOperator;
            isResultDisplayed = false;
        }
    }

    public void calculate() {
        if (!currentInput.isEmpty() && !isResultDisplayed) {
            double input = Double.parseDouble(currentInput);
            if (operator.equals("+")) {
                currentValue += input;
            } else if (operator.equals("-")) {
                currentValue -= input;
            } else if (operator.equals("*")) {
                currentValue *= input;
            } else if (operator.equals("/")) {
                if (input != 0) {
                    currentValue /= input;
                }
            } else if (currentInput.isEmpty()) {
                currentValue = 0;
            }
            currentInput = String.valueOf(currentValue);
            isResultDisplayed = true;
        }
    }

    public void clear() {
        currentInput = "";
        operator = "";
        currentValue = 0;
    }

    public void clearEntry() {
        currentInput = "";
    }

    public void toggleSign() {
        if (!currentInput.isEmpty()) {
            double input = Double.parseDouble(currentInput);
            input = -input;
            currentInput = formatResult(input);
        }
    }

    public void calculateSquareRoot() {
        if (!currentInput.isEmpty()) {
            double input = Double.parseDouble(currentInput);
            if (input >= 0) {
                input = Math.sqrt(input);
                currentInput = formatResult(input);
                isResultDisplayed = true;
            }
        }
    }

    private String formatResult(double value) {
        // Format the result to display a maximum of 8 decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.########");
        return decimalFormat.format(value);
    }

    public String getCurrentInput() {
        return currentInput;
    }
    public void resetOperator() {
        operator = "";
    }
    public void setCurrentValue(double value) {
        currentValue = value;
    }
}