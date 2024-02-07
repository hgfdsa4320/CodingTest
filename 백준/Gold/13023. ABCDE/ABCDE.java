import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean isPossible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<>();
		}
		isPossible = false;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		for (int i = 0; i < n; i++) {
			Collections.sort(arr[i]);
		}
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if(isPossible) break;
			visited[i] = true;
			dfs(0, i, visited);
			visited[i] = false;
		}
		System.out.println(isPossible ? 1 : 0);
	}

	static void dfs(int cnt, int v, boolean[] visited) {
		if(isPossible)
			return;
		if (cnt == 4) {
			isPossible = true;
			return;
		}
		for (int i = 0; i < arr[v].size(); i++) {
			if (!visited[arr[v].get(i)]) {
				visited[v] = true;
				dfs(cnt + 1, arr[v].get(i), visited);
				visited[v] = false;
			}
		}
	}
}