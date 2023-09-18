import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n*2+1];
		int upIdx = 1;
		int downIdx = n;
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n*2;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		boolean[] visited = new boolean[n*2+1];
		while(true) {
			upIdx = upIdx==1?n*2:upIdx-1;
			downIdx = downIdx==1?n*2:downIdx-1;
			if(visited[downIdx]) {
				visited[downIdx] = false;
			}
			int len = q.size();
			for(int i=0;i<len;i++) {
				int tmp = q.poll();
				if(tmp==downIdx) continue;
				int next = tmp==n*2?1:tmp+1;
				if(arr[next]!=0 && !visited[next]) {
					arr[next]--;
					visited[tmp] = false;
					visited[next] = true;
					if(arr[next]==0) {
						k--;
					}
					if(next==downIdx) {
						visited[next] = false;
					}else {
						q.offer(next);	
					}
				}else {
					q.offer(tmp);
				}
				
			}
			if(arr[upIdx]!=0 && !visited[upIdx]) {
				arr[upIdx]--;
				visited[upIdx] = true;
				q.offer(upIdx);
				if(arr[upIdx]==0) k--;
			}
			cnt++;
			if(k<=0) break;
		}
		System.out.println(cnt);
	}
}