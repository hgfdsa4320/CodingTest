import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우 -> 처음에 기간만큼 설정, maxNum = 이 인원 수 만큼, maxNum = 1
 * int now(현재 기간합)-> 최대 20만이므로 가능
 * for문(i=right;i<N) 동안
 * 최대 인원 : maxNum
 * 최대 인원이 들어온 기간 수 : cnt
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int now = 0;
		for (int i = 0; i < X; i++) {
			now += arr[i];
		}
		int maxNum = now;
		int cnt = 1;
		int left = 0;
		int right = X;

		for (int i = right; i < N; i++) {
			now -= arr[left++];
			now += arr[right++];
			if (now > maxNum) {
				maxNum = now;
				cnt = 1;
			} else if (now == maxNum) {
				cnt++;
			}
		}
		if (maxNum == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(maxNum);
			System.out.println(cnt);
		}

	}
}