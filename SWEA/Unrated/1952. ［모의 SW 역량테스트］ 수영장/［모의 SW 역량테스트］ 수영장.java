import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static int answer;
	static int[] price;
	static int[] month;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = Integer.MAX_VALUE;
			price = new int[4];
			arr = new int[13];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			month = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			int[] res = new int[13];
			int total = 0;
			for (int i = 1; i < 13; i++) {
				res[i] = Integer.min(price[0] * month[i], price[1]);
				total += res[i];
			}
			// 3개월 짜리 안끊은 거랑 1년짜리 중 더 싼거
			answer = Math.min(total, price[3]);
			// 3개월 짜리가 섞여있을 때
			combination(1, 1);
			System.out.println("#"+tc+" "+answer);
		}
	}

	static void combination(int start,int cnt) {
		if (start > 12) {
			int totalPrice = findPrice();
			answer = Math.min(answer, totalPrice);
			return;
		}
		for (int i = start; i < 13; i++) {
			for (int j = 0; j < 3; j++) {
				if (i + j < 13) {
					arr[i + j] = cnt;
				}
			}
			combination(i + 3, cnt + 1);
			for (int j = 0; j < 3; j++) {
				if (i + j < 13) {
					arr[i + j] = 0;
				}
			}
			combination(i + 3, cnt);
		}
	}

	static int findPrice() {
		int p = 0;
		int cnt = 0;
		for (int i = 1; i <= 12; i++) {
			if (arr[i] == 0) {
				p += Math.min(price[0] * month[i], price[1]);
			}else{
				cnt = Math.max(cnt, arr[i]);
			}
		}
		return price[2] * cnt + p;
	}
}