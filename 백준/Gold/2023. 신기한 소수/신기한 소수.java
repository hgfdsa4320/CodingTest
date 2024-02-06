import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	1. 소수인지 확인하며 한자리수부터 하나씩 늘려감
	2. 소수이고 N자리수이면 result에 더함
	 */
	static List<Integer> result;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		result = new ArrayList<>();
		dfs(0, 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int cnt, int num) {
		if (isPrime(num)) {
			if (cnt == n) {
				result.add(num);
			} else {
				for (int i = 1; i < 10; i++) {
					dfs(cnt + 1, num * 10 + i);
				}
			}
		}
	}

	static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i ++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}