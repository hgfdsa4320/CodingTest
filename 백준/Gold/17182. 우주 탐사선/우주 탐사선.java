import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 우주 탐사선 ana호는 어떤 행성계를 탐사하기 위해 발사된다.
 * 모든 행성을 탐사하는데 걸리는 최소 시간을 계산하려 한다.
 * 입력으로는 ana호가 탐색할 행성의 개수와 ana호가 발사되는 행성의 위치와 ana호가 행성 간 이동을 하는데 걸리는 시간이 2차원 행렬로 주어진다.
 * 행성의 위치는 0부터 시작하여 0은 행렬에서 0번째 인덱스에 해당하는 행성을 의미한다. 2차원 행렬에서 i, j 번 요소는 i 번째 행성에서 j 번째 행성에 도달하는데 걸리는 시간을 나타낸다.
 * i와 j가 같을 때는 항상 0이 주어진다.
 * 모든 행성을 탐사하는데 걸리는 최소 시간을 계산하여라.
 *
 * 탐사 후 다시 시작 행성으로 돌아올 필요는 없으며 이미 방문한 행성도 중복해서 갈 수 있다.
 *
 * 플로이드 워셜로 각 위치에서 다른 행성까지의 최단 거리 구해놓고
 * 모든 경우의 수 비교 후 최솟값 찾는 느낌
 */
public class Main {
	static int answer;
	static boolean[] visited;
	static int N, K;
	static int[] arr;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i!=j)
					dist[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					if (map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
						dist[i][j] = Math.min(dist[i][j], map[i][k] + map[k][j]);
					}
				}
			}
		}
		answer = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		arr = new int[N];
		arr[0] = K;
		for (int i = 0; i < N; i++) {
			if(i!=K) list.add(i);
		}
		visited = new boolean[list.size()];
		findNum(list, 1);
		System.out.println(answer);
	}

	static void findNum(List<Integer> list, int cnt) {
		if (cnt == N) {
			answer = Math.min(answer,findDistance());
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = list.get(i);
				findNum(list, cnt + 1);
				visited[i] = false;
			}
		}
	}

	static int findDistance() {
		int d = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int s = arr[i];
			int e = arr[i + 1];
			if (dist[s][e] == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			d += dist[s][e];
		}
		return d;
	}
}