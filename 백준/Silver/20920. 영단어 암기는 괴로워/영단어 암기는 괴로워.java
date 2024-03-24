import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 자주 나오는 단어일수록 앞에 배치한다.
 * 해당 단어의 길이가 길수록 앞에 배치한다.
 * 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.length() >= M) {
				map.put(s, map.getOrDefault(s, 0) + 1);
			}
		}
		PriorityQueue<String> pq = new PriorityQueue<>(
			(a, b) -> map.get(a) == map.get(b) ? (a.length() == b.length() ? a.compareTo(b) : b.length() - a.length()) :
				map.get(b) - map.get(a));
		for (String s : map.keySet()) {
			pq.offer(s);
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
	}
}