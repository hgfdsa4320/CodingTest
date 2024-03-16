import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.HashMap;
	import java.util.Map;

	/**
	 * Map<Character,Integer>
	 * 개수 파악해서 홀수가 두개 있으면 실패
	 *
	 *
	 */
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			}
			int oddCnt = 0;
			for (int i = 0; i < 26; i++) {
				if (map.containsKey((char)('A' + i))) {
					if (map.get((char)('A' + i)) % 2 == 1) {
						oddCnt++;
					}
				}
			}
			if (oddCnt > 1) {
				System.out.println("I'm Sorry Hansoo");
			} else {
				StringBuilder sb = new StringBuilder();
				char mid = '0';
				for (int i = 0; i < 26; i++) {
					if (map.containsKey((char)('A' + i))) {
						if (map.get((char)('A' + i)) % 2 == 1) {
							mid = (char)('A' + i);
							for (int j = 0; j < (map.get(mid) - 1) / 2; j++) {
								sb.append(mid);
							}
						} else {
							for (int j = 0; j < map.get((char)('A' + i)) / 2; j++) {
								sb.append((char)('A' + i));
							}
						}
					}
				}
				StringBuilder reverseSb = new StringBuilder(sb);
				reverseSb.reverse();
				if (mid != '0') {
					sb.append(mid);
				}
				sb.append(reverseSb);
				System.out.println(sb);
			}
		}
	}