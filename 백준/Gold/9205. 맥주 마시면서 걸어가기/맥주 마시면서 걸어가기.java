import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 99999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n+2][2];
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			int[][] dist = new int[n+2][n+2];
			for(int i=0;i<n+2;i++) {
				Arrays.fill(dist[i], INF);	
			}
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<n+2;j++) {
					if(i==j) continue;
					dist[i][j] = Math.abs(map[i][0]-map[j][0])+Math.abs(map[i][1]-map[j][1]);
				}
			}
			
			for(int k=0;k<n+2;k++) {
				for(int i=0;i<n+2;i++) {
					if(i==k) continue;
					for(int j=0;j<n+2;j++) {
						if(j==i || j==k) continue;
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			q.offer(0);
			boolean[] visited = new boolean[n+2];
			visited[0] = true;
			boolean isPossible = false;
			while(!q.isEmpty()) {
				int v = q.poll();
				if(v==n+1) {
					isPossible = true;
					break;
				}
				for(int i=0;i<n+2;i++) {
					if(!visited[i] && dist[v][i]<=1000) {
						visited[i] =true;
						q.offer(i);
					}
				}
			}
			if(isPossible) System.out.println("happy");
			else System.out.println("sad");	
			
		}
	}
}