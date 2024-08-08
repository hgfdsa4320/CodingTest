import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1. Stack을 활용하여 모든 값을 스택에 집어넣는다.
 * 2. 초기값 -> 스택에서 하나 뺴서 그 값을 max값으로 잡는다.
 * 3. stack에서 하나씩 빼며 그 값이 max보다 작으면 작은 만큼 값을 더해주고(이익) max값보다 크다면 그 값을 max값으로 설정한다.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			int max = stack.pop();
			long answer = 0;
			while (!stack.isEmpty()) {
				int now = stack.pop();
				if (now < max) {
					answer += max - now;
				} else if (now > max) {
					max = now;
				}
			}
			System.out.println(answer);
		}
	}
}