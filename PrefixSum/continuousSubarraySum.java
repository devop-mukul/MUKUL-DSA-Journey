import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class continuousSubarraySum {
    public static void main(String[] args) {
        continuousSubarraySum solver = new continuousSubarraySum();

        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println("nums=" + Arrays.toString(nums1) + ", k=" + k1 + " => " + solver.checkSubarraySum(nums1, k1)); // true

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 13;
        System.out.println("nums=" + Arrays.toString(nums2) + ", k=" + k2 + " => " + solver.checkSubarraySum(nums2, k2)); // false

        int[] nums3 = {5, 0, 0};
        int k3 = 3;
        System.out.println("nums=" + Arrays.toString(nums3) + ", k=" + k3 + " => " + solver.checkSubarraySum(nums3, k3)); // true
    }
    public boolean checkSubarraySum(int[] nums, int k) {
/* int pro = nums[0];
        int i = 0, j = 1;
        while (j < nums.length) {
            if(pro<k){
                pro *= nums[j];
                j++;
            }
           else if (pro % k > 0) {
                pro /= nums[i];
                i++;
            } else if (pro % k == 0 && j - i >= 1) {
                return true;
            }
        }
        return false;
        */
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1); // To handle the case where the subarray starts from index 0
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (remainderIndexMap.containsKey(remainder)) {
                if (i - remainderIndexMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderIndexMap.put(remainder, i);
            }
        }

        return false;
    }
}
