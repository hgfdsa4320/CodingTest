import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		long[] sum = new long[n + 1];
		long max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + arr[i];
			if (i >= k) {
				sum[i] -= arr[i-k];
				max = Long.max(max, sum[i]);
			}
		}
		System.out.println(max);
	}
}