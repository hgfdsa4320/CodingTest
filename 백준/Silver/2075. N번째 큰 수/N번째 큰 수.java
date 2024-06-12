import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 리스트에 다 넣고 정렬, -> 최대 2,250,000개 -> 8.5MB
 * 정렬 시간 1초 안걸림
 * 이제 배열에서 이분탐색으로 숫자 뽑고, -> 각 열은 정렬되어 있으므로 개수만 세면 됨-> 이것도 이분탐색
 */
public class Main {
	static int[][] map;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list.add(map[i][j]);
			}
		}
		Collections.sort(list);
		int target = N * N - N;
		int start = 0;
		int end = list.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int now = list.get(mid);
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				cnt += findNum(j, now);
			}
			if (cnt == target) {
				System.out.println(now);
				break;
			} else if (cnt > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
	}

	static int findNum(int j, int now) {
		int start = 0;
		int end = N-1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (map[mid][j] < now) {
				start = mid + 1;
			} else if (map[mid][j] > now) {
				end = mid - 1;
			}else{
				return mid;
			}
		}
		return start;
	}
}