import java.io.*;
import java.util.*;

public class Main {
	static int max, min, n;
	static int[] arr;
	static int[] cal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cal = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		findNum(0, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}

	static void findNum(int cnt, int num) {
		if (cnt == n-1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (cal[i] > 0) {
				cal[i]--;
				findNum(cnt + 1, calNum(i, num, arr[cnt + 1]));
				cal[i]++;
			}
		}
	}

	static int calNum(int n, int now, int next) {
		if (n == 0) {
			return now + next;
		} else if (n == 1) {
			return now - next;
		} else if (n == 2) {
			return now * next;
		} else {
			return now / next;
		}
	}
}