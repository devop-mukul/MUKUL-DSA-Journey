public class kLengthApart {
    public static void main(String[] args) {
        kLengthApart solver = new kLengthApart();

        int[] nums1 = {1,0,0,0,1,0,0,1};
        System.out.println("nums1, k=2 -> " + solver.kLengthApart1(nums1, 2)); // expected true

        int[] nums2 = {1,0,0,1,0,1};
        System.out.println("nums2, k=2 -> " + solver.kLengthApart1(nums2, 2)); // expected false

        int[] nums3 = {0,0,0,1};
        System.out.println("nums3, k=0 -> " + solver.kLengthApart1(nums3, 0)); // expected true
    }
    public boolean kLengthApart1(int[] nums, int k) {
        int lastIndex = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                if (lastIndex != -1 && i - lastIndex - 1 < k) {
                    return false;
                }
                lastIndex = i;
            }
        }

        return true;
    }
}