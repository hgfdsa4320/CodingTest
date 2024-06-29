import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= P; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			List<Integer> list = new ArrayList<>();
			int cnt = 0;
			for (int i = 0; i < 20; i++) {
				int idx = 0;
				list.add(Integer.parseInt(st.nextToken()));
				for (int j = list.size() - 2; j >= 0; j--) {
					if (list.get(j) > list.get(list.size()-1)) {
						cnt++;
					} else {
						idx = j + 1;
					}
				}
				if (cnt != 0) {
					int tmp = list.get(list.size() - 1);
					list.remove(list.size() - 1);
					list.add(idx, tmp);
				}
			}
			System.out.println(tc+" "+cnt);

		}
	}
}