import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][N*2];
		int cnt = 0;
		N /= 3;

		while (N > 1) {
			N /= 2;
			cnt++;
		}
		findPattens(cnt, 1, 0, 3 * (int)Math.pow(2,cnt)-1);
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
		if (place == 3) {
			for (int i = x; i <= x + 3 * Math.pow(2, cnt); i++) {
				for (int j = y; j < y + (3 * Math.pow(2, cnt) - (i + x) * 2); j++) {
					arr[i][j] = " ";
				}
			}
		} else if (cnt == 0) {
			for (int i = x; i < x + 3; i++) {
				for (int j = y - (i - x); j <= y + (i - x); j++) {
					if(i==x+1 && j==y) continue;
					arr[i][j] = "*";
				}
			}
		} else {
			findPattens(cnt - 1, 1, x, y);
			findPattens(cnt - 1, 2, x + 3 * (int)Math.pow(2, cnt - 1), y - 3 * (int)Math.pow(2, cnt - 1));
			findPattens(cnt - 1, 3, x + 3 * (int)Math.pow(2, cnt - 1), y - 3 * (int)Math.pow(2, cnt - 1) + 1);
			findPattens(cnt - 1, 4, x + 3 * (int)Math.pow(2, cnt - 1), y + 3 * (int)Math.pow(2, cnt - 1));
		}
	}
}