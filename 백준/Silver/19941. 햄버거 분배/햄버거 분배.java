import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N <= 20,000
 * K <= 10
 * PQ HPQ
 * PQ PPQ
 * 현재 사람이다
 * -> HPQ가 들어있고 현재 먹을 수 있는 위치라면 ++
 * -> 들어있지 않거나 현재 먹을 수 없다면 PPQ에 넣어주기
 * 현재 햄버거다
 * -> PPQ가 들어있고 현재 햄버거를 먹을 수 있는 사람이 있다면 ++
 * -> 비어있거나 현재 먹을 수 있는 사람이 없다면 HPQ에 넣어주기
 * 20 2
 * HHHHHPPPPPHPHPHPHHHP
 * HPQ
 * PPQ 7 8 9 10
 * cnt 2
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		PriorityQueue<Integer> HPQ = new PriorityQueue<>();
		PriorityQueue<Integer> PPQ = new PriorityQueue<>();
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			boolean isPossible = false;
			if (now == 'P') { // 사람이라면
				while (!HPQ.isEmpty()) {
					int prev = HPQ.poll();
					if (i - prev <= K) {
						cnt++;
						isPossible = true;
						break;
					}
				}
				if (!isPossible) {
					PPQ.offer(i);
				}
			} else { // 햄버거라면
				while (!PPQ.isEmpty()) {
					int prev = PPQ.poll();
					if (i - prev <= K) {
						cnt++;
						isPossible = true;
						break;
					}
				}
				if (!isPossible) {
					HPQ.offer(i);
				}
			}

		}
		System.out.println(cnt);
	}
}