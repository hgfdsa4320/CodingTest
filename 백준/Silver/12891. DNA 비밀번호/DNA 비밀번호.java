import java.io.*;
import java.util.*;

public class Main {
	static int s, p;
	static int[] cnt;
	static String dna;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		int answer = 0;
		dna = br.readLine();

		Character[] c = { 'A', 'C', 'G', 'T' };
		st = new StringTokenizer(br.readLine());
		cnt = new int[4];
		for (int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
	
		for (int i = 0; i < p; i++) {
			if (dna.charAt(i) == 'A') {
				cnt[0]--;
			} else if (dna.charAt(i) == 'C') {
				cnt[1]--;
			} else if (dna.charAt(i) == 'G') {
				cnt[2]--;
			} else if (dna.charAt(i) == 'T') {
				cnt[3]--;
			}
		}
		if (isPossible())
			answer++;
		int start = 0;
		for (int end = p; end < s; end++,start++) {
			if (dna.charAt(start) == 'A') {
				cnt[0]++;
			} else if (dna.charAt(start) == 'C') {
				cnt[1]++;
			} else if (dna.charAt(start) == 'G') {
				cnt[2]++;
			} else if (dna.charAt(start) == 'T') {
				cnt[3]++;
			}
			
			if (dna.charAt(end) == 'A') {
				cnt[0]--;
			} else if (dna.charAt(end) == 'C') {
				cnt[1]--;
			} else if (dna.charAt(end) == 'G') {
				cnt[2]--;
			} else if (dna.charAt(end) == 'T') {
				cnt[3]--;
			}
			if (isPossible()) answer++;
			
		}

		System.out.println(answer);
	}

	static boolean isPossible() {

		boolean isOkay = true;
		for (int i = 0; i < 4; i++) {
			if (cnt[i] > 0) {
				isOkay = false;
			}
		}
		if (isOkay)
			return true;
		return false;
	}

}