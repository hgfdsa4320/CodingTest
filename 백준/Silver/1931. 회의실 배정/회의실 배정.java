import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1]==b[1])?a[0]-b[0]:a[1] - b[1]);
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {s, e});
		}
		int now = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if (tmp[0] >= now) {
				now = tmp[1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}