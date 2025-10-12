import java.util.Arrays;

public class maxSumofpairWithEqualSumOfDigits {
    public static void main(String[] args) {
    maxSumofpairWithEqualSumOfDigits solver = new maxSumofpairWithEqualSumOfDigits();
    int[] nums = {51, 71, 17, 42};
    int result = solver.maximumSum(nums);
    System.out.println("Maximum sum of pair with equal sum of digits: " + result);
}
    public int maximumSum(int[] nums) {
        int[] mp = new int[82];
        Arrays.fill(mp, -1);
        int ans = -1;

        for (int num : nums) {
            int sumDigits = 0, temp = num;
            while (temp > 0) {
                sumDigits += temp % 10;
                temp /= 10;
            }

            if (mp[sumDigits] != -1)
                ans = Math.max(ans, num + mp[sumDigits]);

            mp[sumDigits] = Math.max(mp[sumDigits], num);
        }
        return ans;
    }
}
