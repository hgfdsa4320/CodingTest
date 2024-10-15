import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String s1, s2;
	static int[][] dp;
	static int answer;
	static int lcs(int a, int b) {
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[a][b];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		answer = 0;
		dp = new int[s1.length() + 1][s2.length() + 1];
		System.out.println(lcs(s1.length(), s2.length()));
		// for (int i = 1; i < s1.length() + 1; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }
	}
}