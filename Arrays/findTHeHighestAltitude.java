package Arrays;

public class findTHeHighestAltitude {
    public static void main(String[] args) {
        //int gain[] = {-5, 1, 5, 0, -7};
        int gain[] = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int maxHeight = 0, altitude = 0;
        for(int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            maxHeight = Math.max(maxHeight, altitude);
        }
        return maxHeight;
    }
}
