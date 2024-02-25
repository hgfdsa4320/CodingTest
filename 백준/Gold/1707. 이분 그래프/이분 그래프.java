import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] arr;
	static boolean[] visited;
	static Set<Integer> setA;
	static Set<Integer> setB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			setA = new HashSet<>();
			setB = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arr = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			for (int j = 1; j <= V; j++) {
				arr[j] = new ArrayList<>();
			}
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			for (int j = 1; j <= V; j++) {
				if (!visited[j]) {
					setA.add(j);
					divide(j);
				}
			}
			String answer = "YES";
			visited = new boolean[V + 1];
			for (int j = 1; j <= V; j++) {
				if (!visited[j]) {
					visited[j] = true;
					if (!confirm(j)) {
						answer = "NO";
						break;
					}
				}
			}
			System.out.println(answer);
		}
	}

	static void divide(int v) {
		visited[v] = true;
		for (int i = 0; i < arr[v].size(); i++) {
			int next = arr[v].get(i);
			if (!visited[next]) {
				if (setA.contains(v)) {
					setB.add(next);
				} else {
					setA.add(next);
				}
				divide(next);
			}
		}
	}

	static boolean confirm(int v) {
		for (int i = 0; i < arr[v].size(); i++) {
			int next = arr[v].get(i);
			if (!visited[next]) {
				if (setA.contains(v) && setA.contains(next)) {
					return false;
				} else if (setB.contains(v) && setB.contains(next)) {
					return false;
				}
			}

		}
		return true;
	}
}
/**
 * [2]
 * [1 3 4]
 * [2 4]
 * [3 2]
 * 1 2
 * 2 3
 * 3 4
 * 4 2
 *
 *
 *
 * 1 2
 * 2 3
 * 3 4
 * 4 2
 *
 * 1 2
 * 4 3
 * 2 3
 * 4 2
 *
 *
 *
 * 1 2
 * 3 4
 *
 * 1
 * 2 3 4 5 6
 *
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 */