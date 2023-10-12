import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean flag = true;
		for (int i = 0; i < m - 1; i++) {
			if (!isPossible(arr[i], arr[i + 1])) {
				System.out.println("NO");
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println("YES");
	}

	static boolean isPossible(int a, int b) {
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		visited[a] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			if(v==b) return true;
			for(int i=1;i<=n;i++) {
				if(map[v][i]==1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
		return false;
	}
}