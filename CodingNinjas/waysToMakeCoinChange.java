import java.util.Arrays;

public class waysToMakeCoinChange {
    static long dp[][];

    public static void main(String[] args) {
        int denominations[] = {1, 2, 3};
        System.out.println(countWaysToMakeChange(denominations, 4));
    }
    // Count number of ways to make `amount` using coins from index `idx` onwards
    public static long solve(int coins[], int idx, int amount) {

        // If we formed the amount exactly, that's 1 valid way
        if (amount == 0) return 1;

        // No coins left but amount still > 0 -> no way
        if (idx == coins.length) return 0;

        // If amount goes negative, this path is invalid
        if (amount < 0) return 0;

        if (dp[idx][amount] != -1) return dp[idx][amount];

        // Option 1: take the current coin (idx stays same, unlimited supply)
        long take = solve(coins, idx, amount - coins[idx]);//we removed 1+ because we are counting no of ways not number of coins

        // Option 2: skip the current coin (move to next coin)
        long skip = solve(coins, idx + 1, amount);

        return dp[idx][amount] = take + skip;
    }
	
    public static long countWaysToMakeChange(int denominations[], int value){
        dp = new long[denominations.length][value + 1];

        for (long[] rows : dp)
            Arrays.fill(rows, -1);

        return solve(denominations, 0, value);
    }
}