import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		Arrays.fill(arr, -1);
		Deque<int[]> d = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			while (!d.isEmpty() && d.peekLast()[1] < tmp) {
				arr[d.pollLast()[0]] = tmp;
			}
			d.offer(new int[] {i, tmp});
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);

	}
}