package Stack;

public class maxChunksToMakeSorted {
    public static void main(String[] args) {
        maxChunksToMakeSorted solver = new maxChunksToMakeSorted();

        // Test Case 1
        int[] arr1 = {4,3,2,1,0};
        System.out.println("Test 1: " + solver.maxChunksToSorted1(arr1)); // Expected: 1

        // Test Case 2
        int[] arr2 = {1,0,2,3,4};
        System.out.println("Test 2: " + solver.maxChunksToSorted1(arr2)); // Expected: 4

        // Test Case 3
        int[] arr3 = {0,1,2,3,4};
        System.out.println("Test 3: " + solver.maxChunksToSorted1(arr3)); // Expected: 5
    }
    
    public int maxChunksToSorted1(int[] arr) {
        int runningSum = 0, expectedSum = 0, chunks = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            expectedSum += i;
            if (runningSum == expectedSum) {
                chunks++;
            }
        }
        return chunks;
    }
}
