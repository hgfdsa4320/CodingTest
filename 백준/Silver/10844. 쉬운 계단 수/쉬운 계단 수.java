import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int DIV = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[][] arr = new int[101][10];
		for (int i = 1; i < 10; i++) {
			arr[1][i] = 1;
		}
		int now = 1;
		while (now < N) {
			for (int i = 0; i < 10; i++) {
				if (i == 0) {
					arr[now + 1][i + 1] = (arr[now + 1][i + 1] + arr[now][i]) % DIV;
				} else if (i == 9) {
					arr[now + 1][i - 1] = (arr[now + 1][i - 1] + arr[now][i]) % DIV;
				} else {
					arr[now + 1][i + 1] = (arr[now + 1][i + 1] + arr[now][i]) % DIV;
					arr[now + 1][i - 1] = (arr[now + 1][i - 1] + arr[now][i]) % DIV;
				}
			}
			now++;
		}
		for (int i = 0; i < 10; i++) {
			answer = (answer + arr[N][i]) % DIV;
		}
		System.out.println(answer);
	}
}