
import java.util.Scanner;

public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        
        boolean[][] dp = new boolean[n][n];

        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int maxLength = 1;

               for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

                for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        String result = longestPalindromicSubstring(input);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}
