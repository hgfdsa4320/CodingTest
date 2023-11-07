import java.io.*;
import java.util.*;

public class Main {
	static int[] state;
	static int[] arr;
	static Set<Integer> set;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			state = new int[n + 1];
			arr = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				if (state[i] == 0) {
					set = new HashSet<>();
					stack = new Stack<>();
					set.add(i);
					stack.push(i);
					findTeam(i);
				}
			}
			int answer = 0;
			for (int i = 1; i <= n; i++) {
				if (state[i] == 1)
					answer++;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void findTeam(int x) {
		if (set.contains(arr[x])) { // 사이클 형성 된것들 전부 처리
			while (!stack.isEmpty() && stack.peek() != arr[x]) {
				int now = stack.pop();
				state[now] = 2;
			}
			state[stack.pop()] = 2; // 하나더 처리
			
			while (!stack.isEmpty()) { // 사이클 형성 안되는 것들 처리
				int now = stack.pop();
				state[now] = 1;
			}
		}else {
			stack.push(arr[x]);
			set.add(arr[x]);
			if(state[arr[x]]==0) {
				findTeam(arr[x]);	
			}else {
				while(!stack.isEmpty()) {
					int tmp =stack.pop();
					if(state[tmp]==0)
						state[tmp]=1;
				}
			}
		}
	}
}