import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] grade = new int[N][2];
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				grade[i][0] = Integer.parseInt(st.nextToken());
				grade[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(grade, (a, b) -> a[0] - b[0]);
			int answer = 0;
			int value = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				if (grade[i][1] < value) {
					answer++;
					value = grade[i][1];
				}
			}
			System.out.println(answer);
		}
	}
}

/**
 * 1 6
 * 3 4
 * 4 3
 * 5 1
 */