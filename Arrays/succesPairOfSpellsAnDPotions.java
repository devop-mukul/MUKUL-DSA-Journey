package Arrays;

import java.util.Arrays;

public class succesPairOfSpellsAnDPotions {
    public static void main(String[] args) {
    int[] spells = {10, 20, 30};
    int[] potions = {1, 2, 3, 4, 5};
    long success = 40;

    succesPairOfSpellsAnDPotions solver = new succesPairOfSpellsAnDPotions();
    int[] result = solver.successfulPairs(spells, potions, success);

    System.out.println("Successful pairs:");
    System.out.println(Arrays.toString(result)); // Example output: [0, 2, 5]
}   
    public int findPairs(int spell, int[] potions, long success) {
        int n = potions.length;
        int l=0,r=n-1,ind=n;
        while(l<=r) {
            int m = l + (r-l)/2;
            if((long)spell * potions[m] < success) {
                l = m + 1;
            } else {
                ind = m;
                r = m - 1;
            }
        }
        return n-ind;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++) {
            pairs[i] = findPairs(spells[i], potions, success);
        }
        return pairs;
    }
}
