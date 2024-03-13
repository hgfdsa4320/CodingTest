import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9
 * 3+8*7-9*2
 */
public class Main {
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		if (N == 1) {
			System.out.println(Integer.parseInt(s));
		} else {
			findNum(s.charAt(0) - '0', s.substring(1));
			if (N > 4) {
				char c = s.charAt(1);
				int a = s.charAt(0) - '0';
				int b = s.charAt(2) - '0';
				int start = calculate(a, b, c);
				findNum(start, s.substring(3));
			}
			System.out.println(answer);
		}
	}

	static void findNum(int now, String s) {
		if (s.length() >= 2) {
			char c = s.charAt(0);
			int a = s.charAt(1) - '0';
			int next = calculate(now, a, c);
			if (s.length() == 2) {
				answer = Math.max(answer, next);
			} else {
				findNum(next, s.substring(2));
			}
		}

		if (s.length() >= 4) {
			char c = s.charAt(0);
			int a = s.charAt(1) - '0';
			char tmp = s.charAt(2);
			int b = s.charAt(3) - '0';
			int n = calculate(a, b, tmp);
			int next = calculate(now, n, c);
			if (s.length() == 4) {
				answer = Math.max(answer, next);
			} else {
				findNum(next, s.substring(4));
			}

		}
	}
// 1 8
	static int calculate(int a, int b, char c) {
		if (c == '+') {
			return a + b;
		} else if (c == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}
}