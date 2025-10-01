package String;

public class InttoEnglishWords {
    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private String helper(int num) {
        StringBuilder result = new StringBuilder();
        if (num < 20) {
            result.append(belowTwenty[num]);
        } else if (num < 100) {
            result.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        } else if (num < 1000) {
            result.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            result.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            result.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            result.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        InttoEnglishWords converter = new InttoEnglishWords();
        int num1 = 123;
        int num2 = 12345;
        int num3 = 1234567;
        int num4 = 1000000;
        int num5 = 0;

        System.out.println(num1 + " -> " + converter.numberToWords(num1));
        System.out.println(num2 + " -> " + converter.numberToWords(num2));
        System.out.println(num3 + " -> " + converter.numberToWords(num3));
        System.out.println(num4 + " -> " + converter.numberToWords(num4));
        System.out.println(num5 + " -> " + converter.numberToWords(num5));
    }
}
