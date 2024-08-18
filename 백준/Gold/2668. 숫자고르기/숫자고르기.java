import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * for문으로 1~N까지 돌면서 bfs로 시작과 끝이 같은지 확인(단, 첫째줄과 둘째줄이 다른거여야 함)
 * 위의 개수의 최댓값 + 첫째줄과 둘째줄이 같은 수의 개수
 */
public class Main {
	static int N;
	static int[] arr;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= N; i++) {
			if (arr[i] == i) {
				list.add(i);
			} else {
				bfs(i);
			}
		}

		System.out.println(list.size());
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		List<Integer> tmpList = new ArrayList<>();
		q.offer(arr[v]);
		visited[arr[v]] = true;
		tmpList.add(arr[v]);

		while (!q.isEmpty()) {
			int p = q.poll();
			if (p == v) {
				for (int i = 0; i < tmpList.size(); i++) {
					if(!list.contains(tmpList.get(i)))
						list.add(tmpList.get(i));
				}
			}
			int next = arr[p];
			if (!visited[next]) {
				visited[next] = true;
				q.offer(next);
				tmpList.add(next);
			}
		}
	}
}
/**
 *
1 2 3 4 5 6
2 3 1 5 4 6

 */