import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * 8
 * 3 7 1 6 3 5 1 7
 * Stack 이용
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] apart = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			apart[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		int[][] arr = new int[N + 1][2]; // {거리가 가장 가까운 건물의 번호 중 작은 번호, 보이는 건물 개수}
		for (int i = 1; i <= N; i++) {
			arr[i][0] = Integer.MAX_VALUE;
		}
		// 왼쪽에 어떤 건물이 보이는지 확인
		for (int i = 1; i <= N; i++) {
			//옆에 보이는 건물이 없다면
			if (stack.isEmpty()) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					if (apart[i] >= apart[stack.peek()]) {
						stack.pop();
					} else {
						break;
					}
				}
				if (!stack.isEmpty()) {
					arr[i][0] = stack.peek();
					arr[i][1] += stack.size();
				}
				stack.push(i);
			}
		}
		stack = new Stack<>();
		//오른쪽에 어떤 건물이 보이는지 확인
		for (int i = N; i >= 1; i--) {
			//옆에 보이는 건물이 없다면
			if (stack.isEmpty()) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					if (apart[i] >= apart[stack.peek()]) {
						stack.pop();
					} else {
						break;
					}
				}
				if (!stack.isEmpty()) {
					int diff = stack.peek() - i;
					if (diff < Math.abs(i - arr[i][0])) {
						arr[i][0] = stack.peek();
					}
					arr[i][1] += stack.size();
				}
				stack.push(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int num = arr[i][1];
			sb.append(num);
			if (num > 0) {
				sb.append(" ").append(arr[i][0]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}