import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		int x = n / 2;
		int y = n / 2;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		boolean[][] visited = new boolean[n][n];
		int[][] map = new int[n][n];
		int cnt = (int) Math.pow(n, 2);
		int idx = 1;
		int d = 0;

		map[x][y] = idx++;
		visited[x][y] = true;
		while (cnt >= idx) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			map[nx][ny] = idx++;
			visited[nx][ny] =true;
			x = nx;
			y = ny;
			int td = (d==3)?0:d+1;
			int nextX = x + dx[td];
			int nextY = y + dy[td];
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || !visited[nextX][nextY]) {
				d = (d + 1) % 4;
			}
		}
		int px = 0;
		int py = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(map[i][j]).append(" ");
				if(map[i][j]==p){
					px = i+1;
					py = j+1;
				}
			}
			if(i!=n-1) {
				sb.append("\n");				
			}

		}
		System.out.println(sb);
		System.out.println(px+" "+py);
	}
}