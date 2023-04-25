package com.tb.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class CalculatorCore {

    public static BigDecimal evaluate(String expression) {
        //异常情况排除
        if (expression == null || expression.length() == 0 ||
                isOperator(expression.charAt(0)) || isOperator(expression.charAt(expression.length() - 1))) {
            return BigDecimal.ZERO;
        }

        char highPriorityOperator = '\0';
        int highPosition = -1;
        char lowPriorityOperator = '\0';
        int lowPosition = -1;
        //筛选低级操作符和高级操作符
        for (int i = 0; i < expression.length(); i ++) {
            char c = expression.charAt(i);
            if (isLowOperator(c)) {
                lowPriorityOperator = c;
                lowPosition = i;
            } else if (isHighOperator(c)) {
                highPriorityOperator = c;
                highPosition = i;
                break;
            }
        }
        //开始计算
        if (highPriorityOperator != '\0') {
            int frontNumIndex = -1;
            for (int i = highPosition - 1; i >= 0; i --) {
                if (isOperator(expression.charAt(i))) {
                    break;
                }
                frontNumIndex = i;
            }
            //获取运算符前的数字
            BigDecimal frontNum = new BigDecimal(expression.substring(frontNumIndex, highPosition));

            int backNumIndex = -1;
            for (int i = highPosition + 1; i < expression.length(); i ++) {
                if (isOperator(expression.charAt(i))) {
                    break;
                }
                backNumIndex = i;
            }
            BigDecimal backNum = new BigDecimal(expression.substring(highPosition + 1, backNumIndex + 1));
            BigDecimal result = applyOperation(expression.charAt(highPosition), frontNum, backNum);
            String newStr = expression.substring(0, frontNumIndex) + result + expression.substring(backNumIndex + 1);
            return evaluate(newStr);
        } else if (lowPriorityOperator != '\0') {
            int frontNumIndex = -1;
            for (int i = lowPosition - 1; i >= 0; i --) {
                if (isOperator(expression.charAt(i))) {
                    break;
                }
                frontNumIndex = i;
            }
            //获取运算符前的数字
            BigDecimal frontNum = new BigDecimal(expression.substring(frontNumIndex, lowPosition));

            int backNumIndex = -1;
            for (int i = lowPosition + 1; i < expression.length(); i ++) {
                if (isOperator(expression.charAt(i))) {
                    break;
                }
                backNumIndex = i;
            }
            BigDecimal backNum = new BigDecimal(expression.substring(lowPosition + 1, backNumIndex + 1));
            BigDecimal result = applyOperation(expression.charAt(lowPosition), frontNum, backNum);
            String newStr = expression.substring(0, frontNumIndex) + result + expression.substring(backNumIndex + 1);
            return evaluate(newStr);
        } else {
            return new BigDecimal(expression);
        }
    }

    private static boolean isHighOperator(char c) {
        return c == '*' || c == '/';
    }

    private static boolean isLowOperator(char c) {
        return c == '+' || c == '-';
    }

    private static boolean isOperator(char c) {
        return isHighOperator(c) || isLowOperator(c);
    }

    private static BigDecimal applyOperation(char operator, BigDecimal operand1, BigDecimal operand2) {
        switch (operator) {
            case '+':
                return operand1.add(operand2);
            case '-':
                return operand1.subtract(operand2);
            case '*':
                return operand1.multiply(operand2);
            case '/':
                if (Objects.equals(operand2, BigDecimal.ZERO)) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return operand1.divide(operand2, new MathContext(100));
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

}
