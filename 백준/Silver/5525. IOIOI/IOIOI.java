import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			if (cnt == 0 && s.charAt(i) == 'I') {
				cnt = 1;
			} else {
				if (cnt % 2 == 1) {
					if (s.charAt(i) == 'O') {
						cnt++;
					} else {
						if (cnt >= 3) {
							list.add(cnt);
						}
						cnt = 1;
					}
				} else {
					if (s.charAt(i) == 'I') {
						cnt++;
					} else {
						if (cnt >= 3) {
							list.add(cnt);
						}
						cnt = 0;
					}
				}
			}
		}
		if (cnt >= 3) {
			list.add(cnt);
		}
		int res = 0;
		for (Integer i : list) {
			while (i >= N * 2 + 1) {
				res++;
				i -= 2;
			}
		}
		System.out.println(res);
	}
}