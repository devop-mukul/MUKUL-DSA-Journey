package String;

public class compareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersionNumbers cmp = new compareVersionNumbers();
        String version1 = "1.01";
        String version2 = "1.001";
        String version3 = "1.0";
        String version4 = "1.0.0";

        System.out.println("Compare " + version1 + " vs " + version2 + ": " + cmp.compareVersion(version1, version2)); // 0
        System.out.println("Compare " + version3 + " vs " + version4 + ": " + cmp.compareVersion(version3, version4)); // 0
        System.out.println("Compare 1.0.1 vs 1: " + cmp.compareVersion("1.0.1", "1")); // 1
        System.out.println("Compare 7.5.2.4 vs 7.5.3: " + cmp.compareVersion("7.5.2.4", "7.5.3")); // -1
    }
}
