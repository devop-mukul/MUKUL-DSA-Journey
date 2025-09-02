package Math;


public class Climb_Stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(8));
    }
    public static int climbStairs(int n) {
        if (n <= 3) return n;

        int prev1 = 3;
        int prev2 = 2;
        int cur = 0;

        for (int i = 3; i < n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;        
    }
}
