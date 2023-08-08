import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[] dx = {0,1,0,-1}; //우하좌상
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<r;i++) {
			visited = new boolean[n][m];
			rotate();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}	

	static void rotate() {
		
		
		int i = 0;
		while(true) {
			int x = i;
			int y = i;
			int tmp = arr[x][y];
			visited[x][y] = true;
			if(x==n/2 || y==m/2) break;
			int d = 0;
			while(true) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]) {
					visited[nx][ny] = true;
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				}else {
					d = d+1;
					if(d==4) break;
				}
			}
			arr[i+1][i] = tmp;
			i++;
		}
	}
}