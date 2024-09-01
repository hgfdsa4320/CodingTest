import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

import javax.sound.sampled.Line;

/**
 *
 * answer은 각 지점의 최단 거리(다익스트라) 중 최솟값
 *
 *
 */
class LineInfo {
	int destination;
	int distance;

	public LineInfo(int destination, int distance) {
		this.destination = destination;
		this.distance = distance;
	}
}
public class Main {
	static int N, M, roomNum, minDist;
	static List<LineInfo>[] lineList;
	static int[] dist;
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			lineList = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				lineList[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				lineList[a].add(new LineInfo(b, c));
				lineList[b].add(new LineInfo(a, c));
			}
			int K = Integer.parseInt(br.readLine());
			set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			minDist = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++)
				dijkstra(i);
			System.out.println(roomNum);
		}
	}

	static void dijkstra(int v) {
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
		}
		dist[v] = 0;
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<LineInfo> linePQ = new PriorityQueue<>((a, b) -> a.distance - b.distance);
		linePQ.offer(new LineInfo(v, 0));

		while (!linePQ.isEmpty()) {
			LineInfo l = linePQ.poll();
			int now = l.destination;
			int distance = l.distance;
			if(visited[now]) continue;
			visited[now] = true;
			for (int i = 0; i < lineList[now].size(); i++) {
				int next = lineList[now].get(i).destination;
				int nextDist = lineList[now].get(i).distance;
				if (!visited[next]) {
					if (nextDist != Integer.MAX_VALUE && distance + nextDist < dist[next]) {
						dist[next] = distance + nextDist;
						linePQ.offer(new LineInfo(next, dist[next]));
					}
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if (set.contains(i)) {
				sum += dist[i];
			}
		}
		if (sum < minDist) {
			minDist = sum;
			roomNum = v;
		}
	}
}

/**
 * 입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다.
 * 입력의 첫 번째 줄에 테스트 케이스의 개수를 나타내는 자연수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 방의 개수 N (2 ≤ N ≤ 100), 비밀통로의 개수 M(N-1 ≤ M ≤ N(N - 1)/2)이 공백으로 구분되어 주어진다.
 * 그 다음 줄부터 M개의 줄에 걸쳐 비밀통로의 정보(a, b, c)가 주어진다. a와 b는 비밀통로로 연결된 두 방의 번호이며 c는 a와 b를 연결하는 비밀통로의 길이이다. a와 b는 항상 다르며 c는 1 이상 1,000 이하의 자연수이다.
 * 두 방을 연결하는 비밀통로는 반드시 하나씩만 존재한다. 또한 어떤 방에서 다른 방으로 비밀통로를 이용해서 갈 수 없는 경우는 존재하지 않으며, 같은 비밀통로에 대한 정보가 중복되어 주어지지 않는다.
 * 비밀통로의 정보가 모두 주어진 다음 그 다음 줄에 모임에 참여하는 친구의 수 K(1 ≤ K ≤ N)가 주어진다. 각 테스트 케이스의 마지막 줄에는 모임에 참여하는 친구들이 현재 위치해 있는 방의 번호 K개가 공백으로 구분되어 주어진다.
 * 친구들이 있는 방은 항상 N개의 방 중 하나이며, 방 번호가 중복되는 경우는 없다. 즉, 두 명 이상이 한 방에 있는 경우는 입력으로 주어지지 않는다.
 */