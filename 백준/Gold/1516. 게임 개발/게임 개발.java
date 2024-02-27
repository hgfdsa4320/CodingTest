import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위상 정렬 문제
 * 처음에 바로 지을 수 있는 건물들을 큐에 넣고
 * 큐가 빌때까지 반복하며 다음 지을 수 있는 건물들을 넣는다.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int[] D = new int[n + 1];
		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		int[] baseTime = new int[n + 1];
		int[] time = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			baseTime[i] += a;
			while (true) {
				int b = Integer.parseInt(st.nextToken());
				if(b==-1) break;
				arr[b].add(i);
				D[i]++;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (D[i] == 0) {
				q.offer(i);
				time[i] += baseTime[i];
			}
		}
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i = 0; i < arr[x].size(); i++) {
				int next = arr[x].get(i);
				time[next] = Math.max(time[next], time[x]);
				D[next]--;
				if (D[next] == 0) {
					time[next] += baseTime[next];
					q.offer(next);
				}
			}
		}
		for (int i = 1; i < time.length; i++) {
			System.out.println(time[i]);
		}
	}
}