import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		findNum();
		System.out.println(answer);
	}

	static void findNum() {
		int left = 0;
		int right = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			int n = findBlueLay(mid);
			if (n > M) {
				left = mid + 1;
			} else {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}

		}
	}

	static int findBlueLay(int n) {
		int cnt = 1;
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (tmp + arr[i] > n) {
				cnt++;
				if (arr[i] > n) {
					return Integer.MAX_VALUE;
				}
				tmp = arr[i];
			} else {
				tmp += arr[i];
			}
		}
		return cnt;
	}
}