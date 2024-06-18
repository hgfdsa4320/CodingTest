import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


class Info2{
	int idx;
	int value;

	public Info2(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Info2> d = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			Info2 info = new Info2(i, tmp);
			while (!d.isEmpty() && d.peekLast().value > info.value) {
				d.pollLast();
			}
			d.offerLast(info);
			if (d.peekFirst().idx < i - L + 1) {
				d.pollFirst();
			}
			sb.append(d.peekFirst().value).append(" ");
		}
		System.out.println(sb);
	}
}