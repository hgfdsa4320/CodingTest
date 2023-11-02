import java.io.*;
import java.util.*;

public class Main {
	static int[] net;
	static int[] level;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int f = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			net = new int[f * 2 + 1];
			level = new int[f * 2 + 1];
			for (int i = 1; i <= f * 2; i++) {
				net[i] = i;
				level[i] = 1;
			}
			int idx = 1;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < f; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if (!map.containsKey(a)) {
					map.put(a, idx++);
				}
				if (!map.containsKey(b)) {
					map.put(b, idx++);
				}
				int v = map.get(a);
				int w = map.get(b);
				sb.append(union(v, w)).append("\n");
			}
			System.out.print(sb);
		}
	}

	static int union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x < y) {
			net[y] = x;
			level[x] += level[y];
			return level[x];
		} else if (y < x) {
			net[x] = y;
			level[y] += level[x];
			return level[y];
		}
		return level[x];

	}

	static int find(int x) {
		if (x == net[x])
			return x;
		return net[x] = find(net[x]);
	}
}