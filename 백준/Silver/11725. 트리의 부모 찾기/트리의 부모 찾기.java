import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 7
 * 1 6
 * 6 3
 * 3 5
 * 4 1
 * 2 4
 * 4 7
 */
public class Main {
	static List<Integer>[] arr;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new List[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		boolean[] visited = new boolean[N + 1];
		while (!q.isEmpty()) {
			Integer now = q.poll();
			for (int i = 0; i < arr[now].size(); i++) {
				int next = arr[now].get(i);
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
					parent[next] = now;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
}