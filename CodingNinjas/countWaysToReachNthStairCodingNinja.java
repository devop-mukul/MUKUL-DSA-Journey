package CodingNinjas;

public class countWaysToReachNthStairCodingNinja {
    public static void main(String []arg) {
        System.out.println(countDistinctWayToClimbStair(100005));
    }
    public static long countDistinctWayToClimbStair(int nStairs) {
		final int MOD = 1000000007;

		if(nStairs == 0 || nStairs == 1)
			return 1;
		
		long prev1 = 1;
		long prev2 = 1;
		long curr = 0;

		for(int i = 2; i <= nStairs; i++) {
			curr = (prev1 + prev2) % MOD;
			prev2 = prev1;
			prev1 = curr;
		}
		return curr;

	}
    
}
