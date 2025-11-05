package Stack;

import java.util.Arrays;
import java.util.Stack;

public class asteriodCollision {
    public static void main(String[] args) {
        asteriodCollision solver = new asteriodCollision();

        // Test Case 1: [5,10,-5]
        int[] asteroids1 = {5, 10, -5};
        System.out.println("Test 1: " + Arrays.toString(solver.asteroidCollision(asteroids1))); // Expected: [5,10]

        // Test Case 2: [8,-8]
        int[] asteroids2 = {8, -8};
        System.out.println("Test 2: " + Arrays.toString(solver.asteroidCollision(asteroids2))); // Expected: []

        // Test Case 3: [10,2,-5]
        int[] asteroids3 = {10, 2, -5};
        System.out.println("Test 3: " + Arrays.toString(solver.asteroidCollision(asteroids3))); // Expected: [10]
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(a);
                }

                if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while(!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;   
    }
}
