public class carPooling {
    public static void main(String[] args) {
        carPooling solver = new carPooling();

        int[][] trips1 = {{2,1,5},{3,3,7}};
        System.out.println("trips1, cap=4 -> " + solver.carPooling1(trips1, 4)); // expected false
        System.out.println("trips1, cap=5 -> " + solver.carPooling1(trips1, 5)); // expected true

        int[][] trips2 = {{2,1,5},{3,5,7}};
        System.out.println("trips2, cap=3 -> " + solver.carPooling1(trips2, 3)); // expected true

        int[][] trips3 = {{3,2,7},{3,7,9},{8,3,9}};
        System.out.println("trips3, cap=11 -> " + solver.carPooling1(trips3, 11)); // test larger overlaps
    }
    public boolean carPooling1(int[][] trips, int capacity) {
        // Because from and to is between 0 and 1000. Idea is to store counts in an array of size 1001.
        int lengthOfTrip[] = new int[1001];
        for (int trip[] : trips){
            lengthOfTrip[trip[1]] += trip[0]; // Increment when passenger is on board
            lengthOfTrip[trip[2]] -= trip[0]; // decrement when they depart
        }
		// Count total passenger for each bus top
        int carLoad = 0;
        // we have the count array, we perform a line sweep from 0 to 1000 and track its total
        for (int i = 0; i < 1001; i++){
            carLoad += lengthOfTrip[i];
			// Reject when the car is overloaded somewhere
            if(carLoad > capacity) return false;
        }

        return true; // Accept only if all trip is safe
    }
}
