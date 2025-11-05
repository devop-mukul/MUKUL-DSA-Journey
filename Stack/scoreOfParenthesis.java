package Stack;

import java.util.Stack;

public class scoreOfParenthesis {
    public static void main(String[] args) {
    scoreOfParenthesis solver = new scoreOfParenthesis();

    // Test Case 1: "()"
    String s1 = "()";
    System.out.println("Score for " + s1 + ": " + solver.scoreOfParentheses(s1)); // Expected: 1

    // Test Case 2: "(())"
    String s2 = "(())";
    System.out.println("Score for " + s2 + ": " + solver.scoreOfParentheses(s2)); // Expected: 2

    // Test Case 3: "(()(()))"
    String s3 = "(()(()))";
    System.out.println("Score for " + s3 + ": " + solver.scoreOfParentheses(s3)); // Expected: 6
}
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(score);
                score = 0;
            }
            else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }
}
