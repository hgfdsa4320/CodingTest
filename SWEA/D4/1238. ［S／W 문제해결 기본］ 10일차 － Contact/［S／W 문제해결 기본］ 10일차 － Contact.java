import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 *
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start= Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			List<Integer>[] arr = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				arr[i] = new ArrayList<>();
			}
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from].add(to);
			}
			//{번호, 몇번째로 연락 받았는지}
			Queue<int[]> q = new LinkedList<>();
			boolean[] visited = new boolean[101];
			q.offer(new int[] {start, 0});
			visited[start] = true;

			//가장 나중에 연락 받은사람을 찾기 위해
			int max = 0;
			int answer = 0;
			while (!q.isEmpty()) {
				int[] p = q.poll();
				int num = p[0];
				int order = p[1];
				if (order == max) {
					answer = Math.max(answer, num);
				} else if (order > max) {
					max = order;
					answer = num;
				}

				for (int i = 0; i < arr[num].size(); i++) {
					int next = arr[num].get(i);
					if(visited[next]) continue;
					visited[next] = true;
					q.offer(new int[] {next, order + 1});
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}