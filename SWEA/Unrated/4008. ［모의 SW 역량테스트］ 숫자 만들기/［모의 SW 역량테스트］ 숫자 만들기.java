import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, maxValue, minValue;
	static int[] arr;
	static int[] nums;
	static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			maxValue = Integer.MIN_VALUE;
			minValue = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			order = new int[N - 1];
			combination(0);
			System.out.println("#"+tc+" "+(maxValue - minValue));
		}
	}

	static void combination(int now) {
		if (now == N - 1) {
			if (arr[0] + arr[1] + arr[2] + arr[3] == 0) {
				int res = nums[0];
				for (int i = 0; i < order.length; i++) {
					if (order[i] == 0) {
						res += nums[i + 1];
					} else if (order[i] == 1) {
						res -= nums[i + 1];
					} else if (order[i] == 2) {
						res *= nums[i + 1];
					} else {
						res /= nums[i + 1];
					}
				}
				maxValue = Math.max(maxValue, res);
				minValue = Math.min(minValue, res);
			}
			return;
		}
		for (int i = now; i < N - 1; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[j] > 0) {
					order[now] = j;
					arr[j]--;
					combination(i + 1);
					arr[j]++;
				}
			}
		}
	}
}