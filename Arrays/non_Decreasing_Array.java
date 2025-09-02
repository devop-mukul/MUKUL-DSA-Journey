package Arrays;

public class non_Decreasing_Array {
    public static void main(String[] args) {
        //int arr[] = {-2, 7, -1, 0, 1, 2, -3};
        int arr[] = {3, 4, 2, 3};
        System.out.println(isPossible(arr, 4));
    }

    public static boolean isPossible(int[] nums, int n) {
		int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false; // More than one violation not allowed

                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];   // lower left
                } else {
                    nums[i + 1] = nums[i];   // raise right
                }
            }
        }
        return true;
	}
}
