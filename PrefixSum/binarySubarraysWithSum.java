public class binarySubarraysWithSum {

    public static void main(String[] args) {
        binarySubarraysWithSum solver = new binarySubarraysWithSum();

        int[] nums1 = {1, 0, 1, 0, 1};
        System.out.println("nums1, goal=2 -> " + solver.numSubarraysWithSum(nums1, 2)); // expected 4

        int[] nums2 = {0, 0, 0, 0, 0};
        System.out.println("nums2, goal=0 -> " + solver.numSubarraysWithSum(nums2, 0)); // expected 15

        int[] nums3 = {1, 1, 1, 1};
        System.out.println("nums3, goal=1 -> " + solver.numSubarraysWithSum(nums3, 1)); // expected 4
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private int atMost(int[] nums, int goal) {
        int head, tail = 0, sum = 0, result = 0;
        for (head = 0; head < nums.length; head++) {
            sum += nums[head];
            while (sum > goal && tail <= head) {
                sum -= nums[tail];
                tail++;
            }
            result += head - tail + 1;
        }
        return result;
    }
}
