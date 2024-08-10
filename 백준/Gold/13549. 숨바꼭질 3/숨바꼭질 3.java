import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Queue<int[]> q -> 시간, 위치
 * int[] tmp = q.poll()
 * int time = q[0];
 * int place = q[1];
 * place-1, place+1 -> 여기에 time+1 해서 넣고
 * place*2,place*4, ... -> 여기에 time을 넣는데
 * 배열하나 만들어서 원래 저 공간에 들어갈때보다 시간이 작아야댐
 * 배열은 20만
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] times = new int[200001];
		Arrays.fill(times, Integer.MAX_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, N});
		times[N] = 0;
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int time = tmp[0];
			int place = tmp[1];
			if (place == K) {
				answer = Math.min(answer, time);
			}
			if (place - 1 >= 0 && time + 1 < times[place - 1]) {
				times[place - 1] = time + 1;
				q.offer(new int[] {time + 1, place - 1});
			}
			if (place + 1 <= 200000 && time + 1 < times[place + 1]) {
				times[place + 1] = time + 1;
				q.offer(new int[] {time + 1, place + 1});
			}
			int m = 2;
			while (place * m <= 200000 && time < times[place * m]) {
				times[place * m] = time;
				q.offer(new int[] {time, place * m});
				m *= 2;
			}
		}
		System.out.println(answer);
	}
}