import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class contiguousArray {
    public static void main(String[] args) {
        contiguousArray solver = new contiguousArray();

        int[] a1 = {0, 1};
        int[] a2 = {0, 1, 0, 1};
        int[] a3 = {0, 0, 1, 1, 0, 1, 1, 1, 0, 0};
        int[] a4 = {0, 1, 1, 0, 1, 1, 1, 0, 0, 1};

        System.out.println("nums=" + Arrays.toString(a1) + " -> " + solver.findMaxLength(a1));
        System.out.println("nums=" + Arrays.toString(a2) + " -> " + solver.findMaxLength(a2));
        System.out.println("nums=" + Arrays.toString(a3) + " -> " + solver.findMaxLength(a3));
        System.out.println("nums=" + Arrays.toString(a4) + " -> " + solver.findMaxLength(a4));
    }
    
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int subArrayLength = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                subArrayLength = i + 1;
            } else if (mp.containsKey(sum)) {
                subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return subArrayLength;
    }
}
