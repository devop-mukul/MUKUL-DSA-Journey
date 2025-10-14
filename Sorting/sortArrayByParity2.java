public class sortArrayByParity2 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        sortArrayByParity2 obj = new sortArrayByParity2();
        int[] result = obj.sortArrayByParityII(nums);
        System.out.print("Sorted array by parity II: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] << 16;
        }

        int odd = 1;
        int even = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i] >> 16;
            if ((val & 1) == 1) {
                nums[odd] |= val;
                odd += 2;
            } else {
                nums[even] |= val;
                even += 2;
            }
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] & 0xFFFF;
        }

        return nums;
    }
}
