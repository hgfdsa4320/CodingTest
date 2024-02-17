import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		findNum(N, K);
		System.out.println(answer);
	}

	static void findNum(int n, int k) {
		int left = 1;
		int right = Math.min((int)Math.pow(n, 2), (int)Math.pow(10, 9));
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				cnt += Math.min(n, mid / i);
			}
			if (cnt >= k) {
				right = mid - 1;
				answer = Math.min(answer, mid);
			} else {
				left = mid + 1;
			}
		}
	}
}