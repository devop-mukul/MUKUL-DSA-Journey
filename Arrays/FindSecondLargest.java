package Arrays;

public class FindSecondLargest {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
	//               1,  1,  10, 12, 34, 35
        System.out.println("The second largest element is: " + findSecondLargest2ndSol(arr.length, arr));
		System.out.println("The second smallest element is: " + findSecondSmallest2ndSol(arr.length, arr));
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
	public static int findSecondLargest2ndSol(int n, int []arr) {
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		for(int i = 0; i < n; i++) {
			if(arr[i] > first){
				second = first;
				first = arr[i];
			}
			else if(arr[i] < first && arr[i] > second) {
				second = arr[i];
			}
		}
		return (second == Integer.MIN_VALUE) ? -1 : second;
	}

	public static int findSecondSmallest2ndSol(int n, int arr[]) {
		int first_smallest = Integer.MAX_VALUE;
		int second_smallest = Integer.MAX_VALUE;

		for(int i = 0; i < n; i++) {
			if (arr[i] < first_smallest) {
				second_smallest = first_smallest;
				first_smallest = arr[i];
			}
			else if(arr[i] > first_smallest && arr[i] < second_smallest)
				second_smallest = arr[i];
		}
		return (second_smallest == Integer.MAX_VALUE) ? -1 : second_smallest;
	}
}
