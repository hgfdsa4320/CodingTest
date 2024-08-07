import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 전부 빈칸이라고 생각하고
 * 앞 번호부터 차례대로 주어진 수만큼 비워놓고 채우면 됨
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int now = Integer.parseInt(st.nextToken());
			for (int j = 0; j < N; j++) {
				if (arr[j] != 0) {
					continue;
				}
				if (now == 0) {
					arr[j] = i;
				}
				now--;
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}