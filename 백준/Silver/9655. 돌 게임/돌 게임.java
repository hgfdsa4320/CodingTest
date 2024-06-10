import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean answer = false;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[1001][2];
		visited[0][1] = true;
		dfs(0, 1, N);
		if (answer) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

	static void dfs(int now, int turn, int N) {
		if (now == N) {
			if (turn == 0) {
				answer = true;
			}
		}else {
			if (now + 1 <= N) {
				turn = turn == 0 ? 1 : 0;
				if (!visited[now + 1][turn]) {
					visited[now + 1][turn] = true;
					dfs(now + 1, turn, N);
				}
			}
			if (now + 3 <= N) {
				if (!visited[now + 3][turn]) {
					visited[now + 3][turn] = true;
					dfs(now + 3, turn, N);
				}
			}
		}
	}
}