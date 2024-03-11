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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] parent = new int[N];
		boolean[] visited = new boolean[N];
		List<Integer>[] arr = new List[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N ; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == -1) {
				continue;
			}
			parent[i] = n;
			arr[n].add(i);
		}

		int erase = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int p = parent[erase];
		if (p != -1) {
			arr[p].remove(Integer.valueOf(erase));
		}
		q.offer(erase);
		visited[erase] = true;
		while (!q.isEmpty()) {
			Integer now = q.poll();
			for (int i = 0; i < arr[now].size(); i++) {
				int next = arr[now].get(i);

				visited[next] = true;
				q.offer(next);
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i] && arr[i].size() == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
/**
 * 4
 * 3 2 -1 2
 * 0
 *
 * 0
 * 1
 * 2 1
 * 3 0 2
 */