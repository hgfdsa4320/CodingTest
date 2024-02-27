import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] arr;
	static Queue<Integer> q;
	static StringBuilder res;
	static int[] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		D = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			D[b]++;
		}
		q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (D[i] == 0) {
				q.offer(i);
			}
		}
		res = new StringBuilder();
		while (!q.isEmpty()) {
			int x = q.poll();
			res.append(x).append(" ");
			for (int i = 0; i < arr[x].size(); i++) {
				int next = arr[x].get(i);
				D[next]--;
				if (D[next] == 0) {
					q.offer(next);
				}
			}
		}
		System.out.println(res);
	}
}