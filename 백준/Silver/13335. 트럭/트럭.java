import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * n개의 트럭 (1<=n<=1000) -> 트럭의 순서는 바꿀 수 없으며, 트럭의 무게는 같을 수도, 다를 수도 있다
 * 다리 위에는 최대 w(1<=w<=100)대의 트럭이 올라갈 수 있다.
 * 동시에 올라가 있는 트럭들의 무게의 합은 L(1<=L<=1000) 이하가 되야한다.
 *
 * 4 2 10
 * 7 4 5 6
 * int weight = 0;
 * int time = 0;
 * 우선 순위 큐pq -> 무게랑, 나오는 시간-> Ex 1초에 길이가 2인 다리로 올라가면 3
 * time = 1
 * if(pq.size()==L 이거나 weight+ 다음 무게가 >L)이라면 pq.poll()하고 남은 시간 더해주기
 * pq.offer(new int[]{7,4}초
 *
 * while(true){
 * 		if(pq.size()==L 이거나 weight+ 다음 무게가 >L)이라면 pq.poll()하고 남은 시간 더해주기
 * 		아니라면 pq.offer() -> 다음 거
 * }
 * pq({7,4})
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int time = 0; // 현재 시간
		int weight = 0; // 다리 위에 올라간 트럭의 총 무게
		int idx = 0; // 트럭의 인덱스
		int[] truck = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		// {트럭의 무게, 다리에서 나오는 시간)
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		while (true) {
			time++;
			int nextTruck = idx == n ? 0 : truck[idx]; // 다음 트럭의 무게
			idx++;
			// 트럭 위에 w대의 트럭이 올라가 있거나, 현재 다리 위에 있는 트럭의 무게 + 다음 트럭의 무게가 L 보다 크다면
			while (pq.size() == w || weight + nextTruck > L) {
				int[] p = pq.poll();
				weight -= p[0];
				time = Math.max(time,p[1]);
			}
			// 다음 트럭이 있으면
			if (nextTruck != 0) {
				pq.offer(new int[] {nextTruck, time + w});
				weight += nextTruck;
			} else { // 다음 트럭이 없으면
				while (!pq.isEmpty()) {
					int[] p = pq.poll();
					time = p[1];
				}
				break;
			}
		}
		/**
		 * time 5
		 * pq ({4,5}{5,6})
		 * nextTruck 5
		 * weight 9
		 */
		System.out.println(time);
	}
}