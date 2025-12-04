import java.util.Arrays;

public class rodCuttingProblem {
    public static void main(String[] args) {
        // int price[] = {2, 5, 7, 8, 10};
        // System.out.println(cutRod(price, 5));

        int price[] = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price, 8));
    }

	public static int TopDown(int price[], int len, int dp[]) {
		if(len == 0) return 0;

		if(dp[len] != -1) return dp[len];

		int best = 0;

		for(int cut = 1; cut <= len; cut++) {
			int current = price[cut - 1] + TopDown(price, len - cut, dp);
			best = Math.max(current, best);
		}

		dp[len] = best;
		return best;
	}

	public static int recur(int price[], int len) {
		if(len == 0) return 0;

		int best = 0;

		for(int cut = 1; cut <= len; cut++) {
			int curr = price[cut - 1] + recur(price, len - cut);
			best = Math.max(curr, best);
		}

		return best;
	}
	
	public static int cutRod(int price[], int n) {
		// return recur(price, n);
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		return TopDown(price, n, dp);
	}
}
