import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] flavor;
	static boolean[] arr;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		arr = new boolean[N];
		flavor = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}
		findAnswer(0);
		System.out.println(answer);
	}

	static void findAnswer(int cnt) {
		if (cnt == N) {
			boolean isPossible = false;
			for (int i = 0; i < N; i++) {
				if(arr[i])
					isPossible = true;
			}
			if(!isPossible) return;
			int a = 1;
			int b = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i]) {
					a *= flavor[i][0];
					b += flavor[i][1];
				}
			}
			answer = Math.min(answer, Math.abs(a - b));
			return;
		}
		arr[cnt] = true;
		findAnswer(cnt+1);
		arr[cnt] = false;
		findAnswer(cnt + 1);
	}
}