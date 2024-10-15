import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
//
// 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
// 012345
// ACAYKP
// CAPCAK
// 입력
// 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
public class Main {
	static int[][] dp;
	static String s1, s2;

	// 부분 문자열 중 가장 긴 길이를 리턴하는 메서드
	static int lcs(int a, int b) {
		if (a == -1 || b == -1) {
			return 0;
		}
		if(dp[a][b]!=-1) {
			return dp[a][b];
		}
		if (s1.charAt(a) == s2.charAt(b)) {
			return dp[a][b] = lcs(a - 1, b - 1) + 1;
		} else {
			return dp[a][b] = Math.max(lcs(a - 1, b), lcs(a, b - 1));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		dp = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			Arrays.fill(dp[i], -1);
		}
		lcs(s1.length() - 1, s2.length() - 1);

		System.out.println(dp[s1.length() - 1][s2.length() - 1]);
	}
}