import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 재귀 횟수를 구함
 * 함수(재귀횟수, 위치, 좌표)
 *
 */
public class Main {
	static String[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		int cnt = 0;
		while (N > 1) {
			N /= 3;
			cnt++;
		}
		findPattens(cnt, 1, 0, 0);
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			StringBuilder tmp = new StringBuilder();
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == null) {
					tmp.append(" ");
				} else {
					tmp.append(arr[i][j]);
				}
			}
			res.append(tmp).append("\n");
		}
		System.out.println(res);
	}

	static void findPattens(int cnt, int place, int x, int y) {
		if (place == 5) {
			for (int i = x; i < x + (int)Math.pow(3, cnt - 1); i++) {
				for (int j = y; j < y + (int)Math.pow(3, cnt - 1); j++) {
					arr[i][j] = " ";
				}
			}
		} else if (cnt == 0) {
			arr[x][y] = "*";
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					findPattens(cnt - 1, i * 3 + j + 1, x + (int)(i * Math.pow(3, cnt - 1)),
						y + (int)(j * Math.pow(3, cnt - 1)));
				}
			}
		}
	}
}