import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위상 정렬 문제
 *
 */

class IP{
	int x;
	int time;

	public IP(int x, int time) {
		this.x = x;
		this.time = time;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] baseTime = new int[N + 1];
		int[] D = new int[N + 1];
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			baseTime[i] = t;
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int a = Integer.parseInt(st.nextToken());
				D[i]++;
				arr[a].add(i);
			}
		}
		PriorityQueue<IP> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
		for (int i = 1; i <= N; i++) {
			if (D[i] == 0) {
				pq.offer(new IP(i, baseTime[i]));
			}
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			IP p = pq.poll();
			int x = p.x;
			int time = p.time;
			ans = time;
			for (int i = 0; i < arr[x].size(); i++) {
				int next = arr[x].get(i);
				D[next]--;
				if (D[next] == 0) {
					pq.offer(new IP(next, baseTime[next] + time));
				}
			}
		}
		System.out.println(ans);
	}
}