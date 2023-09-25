import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,0,1};
	static int answer = 0;
	static boolean isPossible;
	static char[][] map;
	static int r,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0;i<r;i++) {
			isPossible = false;
			dfs(i,0);
		}
		System.out.println(answer);
	}
	static void dfs(int now,int cnt){
		if(cnt == c-1) {
			answer++;
			isPossible = true;
			return;
		}
	
		for(int i=0;i<3;i++) {
			int nx = now+dx[i];
			int ny = cnt+1;
			if(nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny]=='.') {
				map[nx][ny] = '*';
				dfs(nx,cnt+1);
				if(isPossible) return;
			}
		}
	}
}