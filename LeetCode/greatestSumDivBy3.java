package LeetCode;

import java.util.Arrays;

public class greatestSumDivBy3 {
    public static void main(String[] args) {
        greatestSumDivBy3 obj = new greatestSumDivBy3();
        int nums[] = {4};
        int dp[][] = new int[nums.length][3];

        for(int []row : dp)
            Arrays.fill(row, -1);

        // System.out.println(obj.maxSumDivThree(nums));

        System.out.println(obj.memoFixed(0, 0, nums, dp));
    }
    public int solve(int idx, int nums[], int sum) {
        if (idx == nums.length) {
            if (sum % 3 == 0)
                return sum;
            return Integer.MIN_VALUE; // invalid branch
        }

    int take = solve(idx + 1, nums, sum + nums[idx]);
    int notTake = solve(idx + 1, nums, sum);

    return Math.max(take, notTake);
    }
    public int memoFixed(int idx, int rem, int[] nums, int[][] dp) {//FIXES THE INTEGER MIN VALUE PROBLEM    
    if (idx == nums.length) {
        return (rem == 0) ? 0 : Integer.MIN_VALUE;
    }

    if (dp[idx][rem] != -1) return dp[idx][rem];

    // not take
    int not_take = memo(idx + 1, rem, nums, dp);

    // take
    int next = memo(idx + 1, (rem + nums[idx]) % 3, nums, dp);
    int take = Integer.MIN_VALUE;
    if (next != Integer.MIN_VALUE) {
        take = nums[idx] + next;
    }

    return dp[idx][rem] = Math.max(take, not_take);
}

    public int memo(int idx, int rem, int []nums, int dp[][]) {
        if(idx == nums.length)
            return (rem == 0) ? 0 : Integer.MIN_VALUE;

        if(dp[idx][rem] != -1) return dp[idx][rem];

        int take = nums[idx] + memo(idx + 1, (rem + nums[idx] % 3) % 3, nums, dp);
        int not_take = memo(idx + 1, rem, nums, dp);

        return dp[idx][rem] = Math.max(take, not_take);
    }

    public int maxSumDivThree(int[] nums) {
        int ans = solve(0, nums, 0);
        return Math.max(0, ans); // if ans is -∞, return 0
    }

}
