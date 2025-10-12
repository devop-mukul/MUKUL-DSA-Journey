public class minAmountOfTimeToFillCups {
    public static void main(String[] args) {
    minAmountOfTimeToFillCups solver = new minAmountOfTimeToFillCups();
    int[] cups = {1, 4, 2};
    int minTime = solver.fillCups(cups);
    System.out.println("Minimum amount of time to fill cups: " + minTime);
}
    public int fillCups(int[] A) {
        int mx = 0, sum = 0;
        for(int a: A) {
            mx = Math.max(a, mx);
            sum += a;
        }
        return Math.max(mx, (sum + 1) / 2);
    }
}