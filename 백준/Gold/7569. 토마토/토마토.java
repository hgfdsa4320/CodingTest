import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 1, 0, -1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int m, n, h, answer;
	static int[][][] map;
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new int[n][m][h];
		q= new LinkedList<>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if(map[j][k][i]==1) {
						q.offer(new int[] {j,k,i});
					}
				}
			}
		}
		while(true) {
			int len = q.size();
			int cnt = 0;
			for(int i=0;i<len;i++){
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];
				int z = tmp[2];
				for(int j=0;j<6;j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					int nz = z+dh[j];
					if(nx>=0 && nx<n && ny>=0 && ny<m && nz>=0 && nz<h && map[nx][ny][nz]==0) {			
						map[nx][ny][nz]=1;
						cnt++;
						q.offer(new int[] {nx,ny,nz});
					}
				}
			}
			if(cnt==0) break;
			answer++;
		}
		boolean flag = true;
		Loop1:
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<h;k++) {
					if(map[i][j][k]==0) {
						flag = false;
						break Loop1;
					}
				}
			}
		}
		
		if(flag) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
	}
}