import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 친구끼리 -> 유니온 파인드?
 * 원수는? -> 원수 리스트 만들고 내 원수의 리스트들을 유니온 파인드로 친구로 만들기
 *
 * 1. 유니온 파인드 구현
 * 2. 값 받을 때 F(친구)라면 유니온 파인드
 * E(원수)라면 List에 저장 양방향으로
 * 3. parent[] -> 유니온 파인드 후 다른 개수 구하기 = 최대
 */
public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		//원수를 나타내는 리스트
		List<Integer>[] arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String relation = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 관계가 친구라면
			if (relation.equals("F")) {
				union(a, b);
			} else { // 관계가 원수라면
				arr[a].add(b);
				arr[b].add(a);
			}
		}
		//모든 학생을 비교
		for (int i = 1; i <= n; i++) {
			// 각 학생의 원수 수만큼
			for (int j = 0; j < arr[i].size(); j++) {
				// 원수
				int a = arr[i].get(j);
				// 원수의 원수 수만큼(원수의 원수는 친구)
				for (int k = 0; k < arr[a].size(); k++) {
					//원수의 원수
					int b = arr[a].get(k);
					if(i==b) continue;
					union(i, b);
				}
			}
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			int tmp = find(i);
			if (!set.contains(tmp)) {
				set.add(tmp);
			}
		}
		System.out.println(set.size());
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = find(parent[a]);
	}
}

/**
 * E 1 4
 * F 3 5
 * F 4 6
 * E 1 2
 * 3 5
 * 4 6 2
 * 1
 */