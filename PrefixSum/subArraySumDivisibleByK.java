import java.util.Arrays;
import java.util.HashMap;

public class subArraySumDivisibleByK {
    public static void main(String[] args) {
        subArraySumDivisibleByK solver = new subArraySumDivisibleByK();

        int[] nums1 = {4,5,0,-2,-3,1};
        int k1 = 5;
        System.out.println("nums=" + Arrays.toString(nums1) + ", k=" + k1 + " -> " + solver.subarraysDivByK(nums1, k1)); // expected 7

        int[] nums2 = {5};
        int k2 = 9;
        System.out.println("nums=" + Arrays.toString(nums2) + ", k=" + k2 + " -> " + solver.subarraysDivByK(nums2, k2)); // expected 0

        int[] nums3 = {1,2,3,4,5};
        int k3 = 3;
        System.out.println("nums=" + Arrays.toString(nums3) + ", k=" + k3 + " -> " + solver.subarraysDivByK(nums3, k3)); // example
    }
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefix_sum=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            prefix_sum+=nums[i];
            int rem=prefix_sum % k;
            if(rem<0){
                rem=(rem+k);
            }
            if(map.containsKey(rem)){
                count+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }else{
                map.put(rem,1);
            }

        }
        return count;
    }
}
