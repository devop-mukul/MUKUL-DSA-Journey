import java.util.Arrays;

public class minimumAverageofSmallestAndLargestElements {
    public static void main(String[] args) {
    minimumAverageofSmallestAndLargestElements solver = new minimumAverageofSmallestAndLargestElements();
    int[] nums = {1, 3, 5, 7, 9, 11};
    double minAvg = solver.minimumAverage(nums);
    System.out.println("Minimum average of smallest and largest pairs: " + minAvg);
    }
    public double minimumAverage(int[] nums) {
        // Sort the array to easily pair smallest with largest elements
        Arrays.sort(nums);

        // Array to store averages of each pair
        double[] avg = new double[nums.length / 2];

        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        // Pair smallest with largest and compute averages
        while (left < right) {
            avg[i] = (nums[left] + nums[right]) / 2.0; // ensure floating-point division
            left++;
            right--;
            i++;
        }

        // Find the minimum average among all pairs
        double minElem = Double.MAX_VALUE;
        for (double j : avg) {
            minElem = Math.min(minElem, j);
        }

        return minElem;
    }
}
