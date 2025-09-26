package String;


import java.util.*;

public class basicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0'); // build multi-digit number
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // Save result and sign before parenthesis
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign before parenthesis
                result += stack.pop(); // result calculated before parenthesis
            }
        }

        // add the last number
        if (number != 0) {
            result += sign * number;
        }

        return result;
    }

    public static void main(String[] args) {
        basicCalculator calc = new basicCalculator();
        String expr1 = "1 + 1";
        String expr2 = "2-(1+2)";
        String expr3 = "(2+6-3)+(4-1)";
        System.out.println("Result for \"" + expr1 + "\": " + calc.calculate(expr1));
        System.out.println("Result for \"" + expr2 + "\": " + calc.calculate(expr2));
        System.out.println("Result for \"" + expr3 + "\": " + calc.calculate(expr3));
    }
}
