import java.io.*;
import java.util.*;

public class Main {
	static int n, answer;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		check = new boolean[n + 1];
		findNum(0, 1);
		System.out.println(answer);
	}

	static void findNum(int cnt, int start) {
		if (cnt == n / 2) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (check[i]) {
					list1.add(i);
				} else {
					list2.add(i);
				}
			}
			int value = findSub(list1, list2);
			answer = Math.min(answer, value);
			return;
		}
		for (int i = start; i <= n; i++) {
			if (!check[i]) {
				check[i] = true;
				findNum(cnt + 1, i + 1);
				check[i] = false;
			}
		}
	}

	static int findSub(List<Integer> list1, List<Integer> list2) {
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 0; i < list1.size() - 1; i++) {
			int a = list1.get(i);
			for (int j = i + 1; j < list1.size(); j++) {
				int b = list1.get(j);
				sum1 += map[a][b] + map[b][a];
			}
		}
		
		for (int i = 0; i < list2.size() - 1; i++) {
			int a = list2.get(i);
			for (int j = i + 1; j < list2.size(); j++) {
				int b = list2.get(j);
				sum2 += map[a][b] + map[b][a];
			}
		}

		return Math.abs(sum1 - sum2);
	}
}