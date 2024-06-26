import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int DIV = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][10];
		Arrays.fill(arr[1], 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					arr[i + 1][k] = (arr[i + 1][k] + arr[i][j]) % DIV;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer + arr[N][i]) % DIV;
		}
		System.out.println(answer);
	}
}