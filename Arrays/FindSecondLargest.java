package Arrays;

public class FindSecondLargest {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println("The second largest element is: " + findSecondLargest(arr.length, arr));
    }
    public static int findSecondLargest(int n, int[] arr) {
		for(int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] < arr[j + 1]){
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
		int max = arr[0];
		for(int i = 1; i < n; i++) {
			if(arr[i] < max) {
				return arr[i];
			}
		}
		return -1;
	}
}
