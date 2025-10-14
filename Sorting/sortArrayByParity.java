public class sortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        sortArrayByParity obj = new sortArrayByParity();
        int[] result = obj.sortArrayByParity1(nums);
        System.out.print("Sorted array by parity: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] sortArrayByParity1(int[] nums) {
        int j=0;
       for(int i =0;i<nums.length;i++){
            if(nums[i]%2==0){
                int temp =nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    return nums;
    }
}
