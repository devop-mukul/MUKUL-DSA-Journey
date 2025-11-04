package Stack;

import java.util.Stack;

public class baseballGame {

    public static void main(String[] args) {
        baseballGame solver = new baseballGame();
        
        // Test Case 1
        String[] ops1 = {"5","2","C","D","+"};
        System.out.println("Test 1: " + solver.calPoints(ops1)); // Expected output: 30
        
        // Test Case 2
        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        System.out.println("Test 2: " + solver.calPoints(ops2)); // Expected output: 27
        
        // Test Case 3
        String[] ops3 = {"1","C"};
        System.out.println("Test 3: " + solver.calPoints(ops3)); // Expected output: 0
    }
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        int total = 0;
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if (op.equals("C")) {
                s.pop();
            }
            else if (op.equals("D")) {
                s.push(s.peek() * 2);
            }
            else if (op.equals("+")) {
                int last = s.pop();
                int new1 = last + s.peek();
                s.push(last);
                s.push(new1);
            } 
            else {
                s.push(Integer.parseInt(op));
            }
        }
        while (!s.isEmpty()) {
            total += s.pop();
        }
        return total;
    }
}
