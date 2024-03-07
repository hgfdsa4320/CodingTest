import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


class In{
	int from;
	int to;
	int cost;

	public In(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
}
public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		PriorityQueue<In> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				char tmp = s.charAt(j - 1);
				if (tmp != '0') {
					if (tmp >= 'a') {
						pq.offer(new In(i, j, tmp - 'a' + 1));
					} else {
						pq.offer(new In(i, j, tmp - 'A' + 27));
					}
				}

			}
		}
		int ans = 0;
		while (!pq.isEmpty()) {
			In p = pq.poll();
			if (find(p.from) == find(p.to)) {
				ans += p.cost;
			} else {
				union(p.from, p.to);
			}
		}
		boolean isConnected = true;
		for (int i = 1; i <= N; i++) {
			if (find(i) != 1) {
				isConnected = false;
				break;
			}
		}
		if (isConnected) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}

	static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A == B) return;

		if (A < B) {
			parent[B] = A;
		} else {
			parent[A] = B;
		}
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}