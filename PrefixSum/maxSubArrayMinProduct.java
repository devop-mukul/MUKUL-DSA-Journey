import java.util.Arrays;
import java.util.Stack;

public class maxSubArrayMinProduct {
    public static void main(String[] args) {
        maxSubArrayMinProduct solver = new maxSubArrayMinProduct();

        int[] arr1 = {1, 2, 3, 2};
        System.out.println("arr1 -> " + Arrays.toString(arr1) + " => " + solver.maxSumMinProduct(arr1));

        int[] arr2 = {3, 1, 5, 6, 4, 2};
        System.out.println("arr2 -> " + Arrays.toString(arr2) + " => " + solver.maxSumMinProduct(arr2));

        int[] arr3 = {2, 3, 3, 1, 2};
        System.out.println("arr3 -> " + Arrays.toString(arr3) + " => " + solver.maxSumMinProduct(arr3));
    }
    public int maxSumMinProduct(int[] n) {
    Stack<Integer> st = new Stack<>();
    long dp[] = new long[n.length + 1], res = 0;
    for (int i = 0; i < n.length; ++i)
       dp[i + 1] = dp[i] + n[i];
    for (int i = 0; i <= n.length; ++i) {
        while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
            int j = st.pop();
            res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
        }
        st.push(i);
    }
    return (int)(res % 1000000007);
}
}
