package LeetCode;

import java.util.Arrays;

public class climbStairs {
    static int dp[] = new int[46];
    static {
    Arrays.fill(dp, -1);
    }
    public static void main(String[] args) {
        System.out.println(topDown(45));
    }
    
    public static int topDown(int n) {//Top to Bottom Approach
        if(n < 0) 
            return 0;
        
        if(dp[n] != -1)
        return dp[n];

        if(n == 0)
            return 1;          
            
        int one_step = topDown(n - 1);
        int two_step = topDown(n - 2);

        return dp[n] = one_step + two_step;
    }
}
