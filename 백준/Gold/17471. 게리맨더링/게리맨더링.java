/*
 * 1.부분집합으로 모든 경우의 수를 구함
 * 2.나눠진 두 구역이 각각 0개거나 n개이지 않고 서로 인접한지 확인
 * 3.두 선거구의 인구 차이의 최소값을 구함
 */
import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int answer, n;
	static int[] district;
	static int[] people;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		district = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new ArrayList<>();
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		
		answer = Integer.MAX_VALUE;
		subset(1);
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	static void subset(int num) {
		if (num == n + 1) {
			if (isOkay(0) && isOkay(1)) {
				int diff = Math.abs(findNum(0) - findNum(1));
				answer = Math.min(answer, diff);
			}
			return;
		}
		district[num] = 1;
		subset(num + 1);
		district[num] = 0;
		subset(num + 1);
	}

	static boolean isOkay(int group) {
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			if(district[i] == group) {
				list.add(i);
			}
		}
		if (list.size() == 0 || list.size() == n)
			return false;

		if (!isAdj(list.get(0), list))
			return false;
		return true;
	}

	static boolean isAdj(int v, List<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n + 1];
		visited[v] = true;
		q.offer(v);
		while (!q.isEmpty()) {
			v = q.poll();
			for (int i = 0; i < arr[v].size(); i++) {
				int next = arr[v].get(i);
				if (!visited[next] && list.contains(next)) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		for(int l : list) {
			if(!visited[l]) return false;
		}
		return true;

	}

	static int findNum(int group) {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (district[i] == group)
				cnt += people[i];
		}
		return cnt;
	}
}