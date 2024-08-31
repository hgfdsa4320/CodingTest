import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * map<Integer,Integer> -> 팀 번호 인원 수
 * Queue<Integer> q에 다 넣고 하나씩 빼면서 map으로 인원수 확인 후 6명인 경우에만 점수 부여
 * int[][] num => 현재 팀당 몇명씩 점수를 합했는지랑 합이 몇인지,5명일땐 몇인지 -> 4명만합해야되므로 세야됨
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			Map<Integer, Integer> map = new HashMap<>();
			Queue<Integer> q = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				q.offer(tmp);
				map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			}
			int[][] num = new int[201][3];
			int score = 1;
			while (!q.isEmpty()) {
				int p = q.poll();
				if (map.get(p) == 6) {
					if(num[p][0] < 4) {
						num[p][0]++;
						num[p][1] += score;
					} else if (num[p][0] == 4) {
						num[p][0]++;
						num[p][2] = num[p][1] + score;
					}
					score++;
				}
			}
			int minTeam = 0;
			for (int i = 1; i < num.length; i++) {
				if (map.get(i) == 6) {
					minTeam = i;
					break;
				}
			}
			for (int i = 2; i < num.length; i++) {
				if (num[i][1] != 0 && num[i][1] < num[minTeam][1]) {
					minTeam = i;
				} else if (num[i][1] == num[minTeam][1] && num[i][2] < num[minTeam][2]) {
					minTeam = i;
				}
			}
			System.out.println(minTeam);
		}
		/**
		 * 18
		 *
		 * 1 2 3 1 2 3 1 2 3 3 3 3 2 2 2 1 1 1
		 * 1 28 45
		 * 2 28 42
		 * 3 28 39
		 *
1
21
1 2 3 3 1 3 2 4 1 1 3 5 5 5 5 5 5 1 3 3 1
		 */

	}
}