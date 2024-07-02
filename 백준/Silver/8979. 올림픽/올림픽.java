import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 금메달 수가 더 많은 나라
 * 금메달 수가 같으면, 은메달 수가 더 많은 나라
 * 금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
 * 금은동 순으로 우선순위 큐
 * int rank = 1 시작
 * int num = 0
 * pq가 비어있지 않고 뺏을 때 현재랑 비교해서 같으면 등수 그대로
 * num만 ++
 * 현재보다 등수가 낮으면 rank 증가 시켜주고
 * num = 0 초기화
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(a, b) -> a[1] == b[1] ? (a[2] == b[2] ? b[3] - a[3] : b[2] - a[2]) : b[1] - a[1]);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		int rank = 0;
		int num = 0;
		int[] arr = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			boolean isSame = true;
			for (int i = 0; i < 3; i++) {
				if (p[i + 1] < arr[i]) {
					isSame = false;
					arr[0] = p[1];
					arr[1] = p[2];
					arr[2] = p[3];
				}
			}
			if (isSame) {
				num++;
			}else {
				rank = rank + num + 1;
				num = 0;
			}
			if (p[0] == K) {
				System.out.println(rank);
				break;
			}
		}
	}
}