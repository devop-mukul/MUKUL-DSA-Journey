import java.util.Arrays;

public class countPartitionsWithEvenSumDiff {
    public static void main(String[] args) {
        int nums[] = {7, 14, 3, 9, 2, 11, 4, 6, 5, 9};
        // System.out.println(brute(nums));
        System.out.println(optimized(nums));
    }
    public static int brute(int []nums) {
        int preSum = 0, count = 0;
        int totalSum = Arrays.stream(nums).sum();
        for(int num = 0; num < nums.length - 1; num++) {
            preSum += nums[num];
            int check = Math.abs(((totalSum - preSum) - preSum) % 2);
            if(check == 0) count++;
        }
        return count;
    }
    public static int optimized(int nums[]) {
        int total = 0;
        for(int i = 0; i <= nums.length - 1; i++) {
            total += nums[i];
        }

        return (total % 2 == 0) ? nums.length - 1 : 0;
    }
}