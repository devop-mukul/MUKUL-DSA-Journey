package String;

public class bullsAndCows {
    public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}

public static void main(String[] args) {
    bullsAndCows solver = new bullsAndCows();
    String secret = "1807";
    String guess = "7810";
    String hint = solver.getHint(secret, guess);
    System.out.println("Secret: " + secret + ", Guess: " + guess + " => Hint: " + hint);

    // Another example
    secret = "1123";
    guess = "0111";
    hint = solver.getHint(secret, guess);
    System.out.println("Secret: " + secret + ", Guess: " + guess + " => Hint: " + hint);
}
}
