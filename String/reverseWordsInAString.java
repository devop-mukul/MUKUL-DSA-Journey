package String;

public class reverseWordsInAString {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }

    public static void main(String[] args) {
        reverseWordsInAString rw = new reverseWordsInAString();
        String input = "  the sky   is blue  ";
        String result = rw.reverseWords(input);
        System.out.println("Reversed: \"" + result + "\"");
    }
}