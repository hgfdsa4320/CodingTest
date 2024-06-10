import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 리스트로 받고 N,P비교해서 N이 P보다 작으면 그냥 이진 검색 해서 넣어주기
 * N이 P보다 같거나 크면 끝 값보다 큰지 확인하고 작거나 같으면 -1, 아니면 이진검색
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int answer;
		if (list.size() == 0) {
			answer = 1;
		} else {
			if (N < P) {
				answer = findRank(list, score);
			} else {
				if (score <= list.get(list.size() - 1)) {
					answer = -1;
				} else {
					answer = findRank(list, score);
				}
			}
		}
		System.out.println(answer);
	}

	static int findRank(List<Integer> list, int score) {
		int left = 0;
		int right = list.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (score >= list.get(mid)) {
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return left+1;
	}
}