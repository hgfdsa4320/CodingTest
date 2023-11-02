import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new int[] { a, b, c });
		}
		int answer = 0;
		while (!pq.isEmpty()) {
			int a = pq.peek()[0];
			int b = pq.peek()[1];
			int c = pq.poll()[2];

			if (find(a) != find(b)) {
				union(find(a), find(b));
				answer += c;
			}
		}
		System.out.println(answer);
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int findA = find(a);
		int findB = find(b);
		if (findA < findB) {
			parent[b] = findA;
		} else {
			parent[a] = findB;
		}
	}

}