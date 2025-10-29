public class stoneGame2 {
    public static void main(String[] args) {
        stoneGame2 solver = new stoneGame2();

        int[] piles1 = {2, 7, 9, 4, 4};
        System.out.println("piles=" + java.util.Arrays.toString(piles1) + " -> Alice max = " + solver.stoneGameII(piles1));

        int[] piles2 = {1, 2, 3, 4, 5, 6};
        System.out.println("piles=" + java.util.Arrays.toString(piles2) + " -> Alice max = " + solver.stoneGameII(piles2));

        int[] piles3 = {8, 15, 3, 7};
        System.out.println("piles=" + java.util.Arrays.toString(piles3) + " -> Alice max = " + solver.stoneGameII(piles3));
    }
    
    public int stoneGameII(int[] piles) {
        int totalPiles = piles.length;
        int[] suffixSums = new int[totalPiles + 1];
        for (int i = totalPiles - 1; i >= 0; i--) {
            suffixSums[i] = suffixSums[i + 1] + piles[i];
        }
        return maxStonesAliceCanGet(suffixSums, 1, 0, new int[totalPiles][totalPiles + 1]);
    }

    private int maxStonesAliceCanGet(int[] suffixSums, int m, int currentPile, int[][] memo) {
        int totalPiles = suffixSums.length - 1;
        
        if (currentPile >= totalPiles) return 0;
        
        if (currentPile + 2 * m >= totalPiles) {
            return suffixSums[currentPile];
        }
        
        if (memo[currentPile][m] != 0) return memo[currentPile][m];
        
        int maxStones = 0;
        
        for (int x = 1; x <= 2 * m; x++) {
            int currentStones = suffixSums[currentPile] - maxStonesAliceCanGet(suffixSums, Math.max(m, x), currentPile + x, memo);
            maxStones = Math.max(maxStones, currentStones);
        }
        
        memo[currentPile][m] = maxStones;
        return maxStones;
    }
}
