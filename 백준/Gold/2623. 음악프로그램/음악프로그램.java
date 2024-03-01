import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위상 정렬 문제
 *
 * 6 3
 * 3 1 4 3
 * 4 6 2 5 4
 * 2 2 3
 *
 * 1    4 3
 * 2    5 4 3
 * 3
 * 4    3
 * 5    4
 * 6    2 5 4
 *
 * 1 2 3 4 5 6
 *   1 3 4 2
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 가수의 수
		int M = Integer.parseInt(st.nextToken()); // 보조 PD의 수
		ArrayList<Integer>[] pd =new ArrayList[M];
		int[] D = new int[N + 1];
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			pd[i] = new ArrayList();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				pd[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < pd.length; i++) {
			for (int j = 0; j < pd[i].size()-1; j++) {
				int a = pd[i].get(j);
				for (int k = j + 1; k < pd[i].size(); k++) {
					arr[a].add(pd[i].get(k));
					D[pd[i].get(k)]++;
				}
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (D[i] == 0) {
				q.offer(i);
			}
		}
		StringBuilder res = new StringBuilder();
		int cnt = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			res.append(x).append("\n");
			cnt++;
			for (int i = 0; i < arr[x].size(); i++) {
				int next = arr[x].get(i);
				D[next]--;
				if (D[next] == 0) {
					q.offer(next);
				}
			}
		}
		if (cnt == N) {
			System.out.println(res);
		} else {
			System.out.println(0);
		}
	}
}