package Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;



public class exclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        // Only stores start or last Duration
        // e.g.
        // stack=["0:start:0", "1:start:2"]
        // stack=["0:start:0", "lastDuration:4"]
        Stack<String> stack = new Stack<>();
        for (String s: logs) {
            if (s.indexOf("start") >= 0) {
                stack.push(s);
            } else {
                int gap = 0;
                while (!stack.isEmpty() && stack.peek().startsWith("lastDuration")) {
                    gap += Integer.valueOf(stack.pop().split(":")[1]);                    
                }
                String[] begin = stack.pop().split(":");
                String[] end = s.split(":");
                int id = Integer.valueOf(begin[0]);
                int startTime = Integer.valueOf(begin[2]);
                int endTime = Integer.valueOf(end[2]);
                int duration = endTime - startTime + 1;
                res[id] += duration - gap;
                stack.push("lastDuration:" + (duration));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        exclusiveTimeOfFunctions solver = new exclusiveTimeOfFunctions();

        // Test Case 1
        List<String> logs1 = Arrays.asList(
            "0:start:0",
            "1:start:2",
            "1:end:5",
            "0:end:6"
        );
        System.out.println("Test 1: " + Arrays.toString(solver.exclusiveTime(2, logs1))); // Expected: [3,4]

        // Test Case 2
        List<String> logs2 = Arrays.asList(
            "0:start:0",
            "0:start:2",
            "0:end:5",
            "0:start:6",
            "0:end:6",
            "0:end:7"
        );
        System.out.println("Test 2: " + Arrays.toString(solver.exclusiveTime(1, logs2))); // Expected: [8]
    }
}
