package Arrays;

import java.util.Arrays;

public class runningSum {
    public static void main(String[] args) {
        int nums[] = {3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(runningSum(nums)));
    }
    public static int[] runningSum(int nums[]) {
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            nums[i] = runningSum;
        }
        return nums;
    }
}
