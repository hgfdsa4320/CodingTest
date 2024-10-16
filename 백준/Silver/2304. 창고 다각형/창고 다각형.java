import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
4 6 3 10 4 8 6

4 6 6 10 8 8 6

4 3

4
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 높이를 내림차순으로 우선순위 큐
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			pq.offer(H);
		}

		int answer = 0;
		int now = 0;
		for (int i = 1; i <= 1000; i++) {
			if (pq.isEmpty()) {
				break;
			}
			int nowHeight = arr[i]; //현재 높이
			pq.remove(Integer.valueOf(nowHeight));
			if (nowHeight > now) {
				now = nowHeight;
			}
			answer += now;
			if (!pq.isEmpty() && pq.peek() < now) {
				now = pq.peek();
			}

		}
		System.out.println(answer);
	}
}