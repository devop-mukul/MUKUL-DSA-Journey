public class minSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int curSum = 0;

        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];

            while (curSum >= target) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                curSum -= nums[left];
                left++;
            }
        }
        
        return minLen != Integer.MAX_VALUE ? minLen : 0;        
    }
    
    public static void main(String[] args) {
        minSizeSubarraySum solver = new minSizeSubarraySum();

        // If arguments provided: first is target, remaining are array elements.
        if (args.length >= 2) {
            try {
                int target = Integer.parseInt(args[0]);
                int[] nums = new int[args.length - 1];
                for (int i = 1; i < args.length; i++) {
                    nums[i - 1] = Integer.parseInt(args[i]);
                }
                int res = solver.minSubArrayLen(target, nums);
                System.out.println(res);
                return;
            } catch (NumberFormatException e) {
                System.err.println("Invalid number in arguments. Falling back to demo.");
            }
        }

        // Default demo
        int[] demo = {2, 3, 1, 2, 4, 3};
        int demoTarget = 7;
        System.out.println("Demo input: target=" + demoTarget + ", nums=" + java.util.Arrays.toString(demo));
        int result = solver.minSubArrayLen(demoTarget, demo);
        System.out.println("Min subarray length = " + result);
    }
}