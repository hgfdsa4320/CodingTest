import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] A;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			System.out.println(isExist(tmp));
		}
	}

	static int isExist(int tmp) {
		int left = 0;
		int right = N-1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == tmp) {
				return 1;
			} else if (A[mid] > tmp) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 0;
	}
}