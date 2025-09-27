package String;

import java.util.List;
import java.util.LinkedList;

public class diffWaysToAddParenthesis {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }

    public static void main(String[] args) {
        diffWaysToAddParenthesis solver = new diffWaysToAddParenthesis();
        String input = "2*3-4*5";
        List<Integer> results = solver.diffWaysToCompute(input);

        System.out.println("Possible results for \"" + input + "\":");
        for (int res : results) {
            System.out.println(res);
        }
    }
}
