import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 공백, 더하기, 빼기 순
 * 중복순열(완탐)
 * 최대 3^8 -> 약 6000
 *
 */
public class Main {
	static char[] arr;
	static int N;
	static StringBuilder sb;
	static Map<Integer,Character> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		map = new HashMap<>();
		map.put(0, ' ');
		map.put(1, '+');
		map.put(2, '-');
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N];
			findOrder(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void findOrder(int order) {
		if (order == N) {
			if (findValue() == 0) {
				for (int i = 1; i < N; i++) {
					sb.append(i).append(arr[i]);
				}
				sb.append(N).append("\n");
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			arr[order] = map.get(i);
			findOrder(order + 1);
		}
	}

	static int findValue() {
		int prev = 0;
		int now = 0;
		char op  = '+';
		for (int i = 1; i < N; i++) {
			now = now * 10 + i;
			char c = arr[i];
			if (c == '+') {
				if (op == '+') {
					prev = prev + now;
				} else {
					prev = prev - now;
				}
				op = '+';
				now = 0;
			} else if (c == '-') {
				if (op == '-') {
					prev = prev - now;
				} else {
					prev = prev + now;
				}
				op = '-';
				now = 0;
			}
		}
		now = now * 10 + N;
		if (op == '+') {
			prev = prev + now;
		} else {
			prev = prev - now;
		}
		return prev;
	}
}

/**
 * 1 2 3
 *  + -
 * prev = 3
 * now = 0
 * op -
 * c -
 * 1-2 3+4+5+6+7
 *
 * int prev 1
 * int now 2 => +,-일때 초기화
 * char op +
 * prev += now
 * 	now = now*10+i;
 *
 * 1+2-3
 *
 * 1+2-3+4-5-6+7
 * 1+2-3-4+5+6-7
 * 1-2 3+4+5+6+7
 * 1-2 3-4 5+6 7
 * 1-2+3+4-5+6-7
 * 1-2-3-4-5+6+7
 */