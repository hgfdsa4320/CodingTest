import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= b.length() - a.length(); i++) {
			int cnt = 0;
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) != b.charAt(i + j)) {
					cnt++;
				}
			}
			answer = Math.min(answer, cnt);
		}
		System.out.println(answer);
	}
}