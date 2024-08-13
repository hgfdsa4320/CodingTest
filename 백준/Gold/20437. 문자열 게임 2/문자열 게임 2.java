import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. List<Integer>[] alpha -> 배열 만들고-> 각각의 인덱스 다넣기
 * 2. 0부터 26까지 순회하며 최솟값 최댓값 구하기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			List<Integer>[] alpha = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				alpha[i] = new ArrayList<>();
			}
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < W.length(); i++) {
				char c = W.charAt(i);
				alpha[c - 'a'].add(i);
			}
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 26; i++) {
				if(alpha[i].size()<K) continue;
				for (int j = 0; j <= alpha[i].size() - K; j++) {
					int len = alpha[i].get(j + K - 1) - alpha[i].get(j) + 1;
					min = Math.min(min, len);
					max = Math.max(max, len);
				}
			}
			if (min == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(min+" "+max);
			}
		}
	}
}