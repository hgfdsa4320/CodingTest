import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			List<Integer>[] arr = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				arr[i] = new ArrayList<>();
			}
			int[] count = new int[V + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from].add(to);
				count[to]++;
			}

			StringBuilder sb = new StringBuilder();
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= V; i++) {
				if (count[i] == 0) {
					sb.append(i).append(" ");
					q.offer(i);
				}
			}
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int i = 0; i < arr[now].size(); i++) {
					int next = arr[now].get(i);
					count[next]--;
					if (count[next] == 0) {
						sb.append(next).append(" ");
						q.offer(next);
					}
				}
			}
			System.out.println("#"+tc+" "+sb);
		}
	}
}