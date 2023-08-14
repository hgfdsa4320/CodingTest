import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[w];
		for(int i=0;i<w;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> q = new LinkedList<>();
		int answer = 0;
		int start = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < start) {
				for (int j = 0; j < q.size(); j++) {
					int tmp = q.poll();
					if(tmp<=arr[i]) {
						answer+=arr[i]-tmp;
						q.offer(arr[i]);
					}else {
						q.offer(tmp);
					}
					
				}
				q.offer(arr[i]);

			} else {
				while(!q.isEmpty()) {
					answer+=start-q.poll();
				}
				q = new LinkedList<>();
				start = arr[i];
			}
		}
		System.out.println(answer);
	}

}