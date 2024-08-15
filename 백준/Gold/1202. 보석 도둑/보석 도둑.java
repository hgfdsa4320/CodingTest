import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Dp?
 * 보석이 N개, 가방이 K개 -> (1 ≤ N, K ≤ 300,000)
 * 가방에는 최대 1개의 보석만 넣을 수 있음
 * 그럼 보석을 가치 순으로 정렬한 다음에 -> 가방을 이분탐색해서?
 * int[][] jewery -> {무게, 가치} => 가치순으로 내림차순, 가치가 같으면 무게가 낮은순으로 내림차순 정렬
 * int[] bag -> 오름차순 정렬
 * for문 돌면서 보석의 가치를 가방에서 이분 탐색으로 찾는다 -> 근데 이게 이미 차있는걸 어쩌지
 * List<>?-> 지우는거 O(n) -> 30a만번
 *
 * for(int i=0;i<) 30만
 * 	이분 탐색 -> log30만
 * 	지우는거 대신 union find?
 *
 * parent[] 만들고
 * parent[i]==i면  현재껀 안쓴거
 * 썻으면 union(i,i+1) -> 여기 부분도 좀 설계
 * 2
 * parent[2] = 3;
 * union(2,3)
 * parent[3] = 5;
 * bag[2]
 *
 * 1. int[][] jewelry -> {무게, 가치} => 가치순으로 내림차순, 가치가 같으면 무게가 낮은순으로 오름차순 정렬
 * 2. int[] bag -> 오름차순 정렬
 * for문 돌면서 보석 정보 가져오기
 * 	보석 무게를 가방에서 이진탐색으로 찾기
 * 	if 만약 이진탐색으로 찾은 인덱스가 a라면
 * 	bags[find(a)]로 현재 보석을 넣을 수 있는 가장 가벼운 가방을 찾는다 (유니온 파인드)
 * 	그럼 현재 가방을 못쓰므로, union(find(a),find(a)+1) => 범위가 넘어가거나 끝까지 가방이 찾을때 설정하기
 *
 *
 */
public class Main {
	static int N, K;
	static int[] parent, bag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] jewelry = new int[N][2];
		parent = new int[K];
		bag = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewelry[i][0] = Integer.parseInt(st.nextToken());
			jewelry[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
			parent[i] = i;
		}
		Arrays.sort(jewelry, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
		Arrays.sort(bag);
		long answer = 0;
		for (int[] jew : jewelry) {
			int w = jew[0];
			int v = jew[1];
			int idx = binarySearch(w);
			if(idx==K) continue; // 담을 수 있는 가방이 없음
			int place = find(idx);

			if(place==-1) continue; // 마지막 가방까지 이미 담겨있음
			answer += v;
			union(place, place + 1);
		}
		System.out.println(answer);
	}

	static void union(int a, int b) {
		if (b == K) {
			parent[a] = -1;
			return;
		}
		a = find(a);
		b = find(b);
		parent[a] = b;
	}

	static int find(int a) {
		if(parent[a] == -1) return -1;
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

	static int binarySearch(int n) {
		int left = 0;
		int right = K - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (bag[mid] == n) {
				if (mid > 0 && bag[mid - 1] == bag[mid]) {
					right = mid - 1;
				} else {
					return mid;
				}

			} else if (bag[mid] > n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}

/**
 * 1 2 3 4
 * n = 5
 * left  3
 * right 3
 * mid =1
 *
 *
3 3
2 65
2 88
2 21
1
2
3
 *
 */
/*
3 2
3 65
3 88
 * 3 21
 * 3
 * 3
 */