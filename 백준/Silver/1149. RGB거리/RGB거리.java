import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + a;
			arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + b;
			arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + c;
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (arr[n][i] < answer) {
				answer = arr[n][i];
			}
		}
		System.out.println(answer);
	}
}