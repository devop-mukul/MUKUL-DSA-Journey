package LeetCode;
import java.util.Arrays;

public class longestCommonSubsequence {
    int m, n;
    int dp[][];

    public int topDown(String s1, String s2, int i, int j) {
        if(i >= m || j >= n)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + topDown(s1, s2, i + 1, j + 1);
        
        return dp[i][j] = Math.max(topDown(s1, s2, i + 1, j), topDown(s1, s2, i, j + 1));
    }

    public int bottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];

        for(int row = 0; row < m + 1; row++)
            dp[row][0] = 0;

        for(int col = 0; col < n + 1; col++)
            dp[0][col] = 0;

        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        for(int i = 0; i < m + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }
    public int longestCommonSubsequence1(String s1, String s2) {
        m = s1.length();  // assign to class variables
        n = s2.length();

        // dp = new int[m][n]; // class DP table for topDown approach

        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        return bottomUp(s1, s2);
        
        // return topDown(s1, s2, 0, 0);
    }
    public static void main(String[] args) {
        longestCommonSubsequence obj = new longestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence1("abcde", "ace"));
    }
}