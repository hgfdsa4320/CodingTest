import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 첫번째 단어랑 i번째 단어 길이가 같다? => 문자가 다른게 두개가 있으면 됨
 * 2. 첫번째 단어와 i번째 단어랑 길이가 다르다? 1개만 달라야됨
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String word = br.readLine();
		int[] arr = new int[26];
		for (int i = 0; i < word.length(); i++) {
			arr[word.charAt(i) - 'A']++;
		}
		int answer = 0;
		for (int i = 0; i < N - 1; i++) {
			String tmp = br.readLine();
			if(tmp.length()>word.length()+1 || tmp.length()<word.length()-1)
				continue;
			int[] tmpArr = new int[26];
			for (int j = 0; j < tmp.length(); j++) {
				tmpArr[tmp.charAt(j) - 'A']++;
			}
			int cnt = 0;
			for (int j = 0; j < 26; j++) {
				if (arr[j] != tmpArr[j]) {
					cnt += Math.abs(arr[j] - tmpArr[j]);
				}
			}
			if (cnt == 0 || (cnt == 1 && word.length() != tmp.length()) || (cnt == 2
				&& word.length() == tmp.length())) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}