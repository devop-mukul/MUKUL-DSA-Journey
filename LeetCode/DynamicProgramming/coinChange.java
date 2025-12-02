import java.util.Arrays;

public class coinChange {
    final int INF = 1_000_000_000;
    int dp[][];

    public static void main(String[] args) {
        coinChange obj = new coinChange();
        int coins[] = {1, 2, 5};
        int amount = 11;
        System.out.println(obj.coinChangeFxn(coins, amount));
    }
    public int TopDown(int coins[], int idx, int amount) {
        if(amount == 0) return 0;
        if(idx == coins.length) return INF;
        if(amount < 0) return INF;

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int take = 1 + TopDown(coins, idx, amount - coins[idx]);
        int skip = TopDown(coins, idx + 1, amount);

        return dp[idx][amount] = Math.min(take, skip);
    }

    public int coinChangeFxn(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];

        for(int rows[] : dp)
            Arrays.fill(rows, -1);

        int ans = TopDown(coins, 0, amount);
        return (ans >= INF) ? -1 : ans;
    }
}
