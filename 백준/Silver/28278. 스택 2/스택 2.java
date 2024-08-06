import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
 * 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 3: 스택에 들어있는 정수의 개수를 출력한다.
 * 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (num == 2) {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			} else if (num == 3) {
				sb.append(stack.size()).append("\n");
			} else if (num == 4) {
				if (stack.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}