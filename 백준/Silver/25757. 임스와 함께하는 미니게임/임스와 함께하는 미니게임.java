import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String k = st.nextToken();

		Map<String, Integer> map = new HashMap<>();
		map.put("Y", 2);
		map.put("F", 3);
		map.put("O", 4);

		int cnt = map.get(k);
		int answer = 0;
		HashSet<String> set = new HashSet<>();
		HashSet<String> tmpSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if(set.contains(s)) continue;
			tmpSet.add(s);
			set.add(s);
			if (tmpSet.size() == cnt-1) {
				answer++;
				tmpSet = new HashSet<>();
			}
		}
		System.out.println(answer);

	}
}