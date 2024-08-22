import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.xml.crypto.Data;

/**
 * dp[i][j] => i번째 길이의 j번째 인덱스 선택
 *
 */
public class Main {
	static String s1,s2, s3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s1 = st.nextToken();
			s2 = st.nextToken();
			s3 = st.nextToken();
			if (bfs()) {
				sb.append("Data set ").append(tc).append(": yes").append("\n");
			} else {
				sb.append("Data set ").append(tc).append(": no").append("\n");
			}
		}
		System.out.println(sb);
	}

	static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[s1.length() + 1][s2.length() + 1];
		q.offer(new int[] {0, 0, 0});
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int i = p[0];
			int j = p[1];
			int k = p[2];
			if (k == s3.length()) {
				return true;
			}
			if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && !visited[i + 1][j]) {
				visited[i + 1][j] = true;
				q.offer(new int[] {i + 1, j, k + 1});
			}
			if (j < s2.length() && s2.charAt(j) == s3.charAt(k) && !visited[i][j + 1]) {
				visited[i][j + 1] = true;
				q.offer(new int[] {i, j + 1, k + 1});
			}
		}
		return false;
	}
}

/**
 *
 * cat tree tcraete
 * i j idx
 * 2 2  5
 *
 * dp[0][1] =
 * dp[0][2] = 0
 *
 * dp[0][2] =
 *
 * cat tree catrtee
 * cat tree cttaree
 */