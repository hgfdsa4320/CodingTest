import java.io.*;
import java.util.*;

public class Main {

	static class Dust {
		int x;
		int y;
		int amount;

		public Dust(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int R,C,T,x,y;
	static Queue<Dust> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		x = 0;
		y = 0;
		q = new LinkedList<>();
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && x == 0) {
					x = i;
					y = j;
				}else if(map[i][j]>0) {
					q.offer(new Dust(i,j,map[i][j]));
				}
			}
		}
		findAmount();
		int answer = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) answer+=map[i][j];
			}
		}
		System.out.println(answer);
	}
	static void findAmount() {
		while(T>0) {
			int len = q.size();
			for(int i=0;i<len;i++) {
				Dust d = q.poll();
				int x = d.x;
				int y=  d.y;
				int amount = d.amount;
				int cnt = 0;
				int tmp = 0;
				for(int j=0;j<4;j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]>=0) {
						tmp = amount/5;
						map[nx][ny]+=tmp;
						cnt++;
					}
				}
				
				map[x][y] = map[x][y]-cnt*tmp;
				
			}
			int d = 0;
			int nx = x+dx[d]; // 공기 청정기 위쪽 부분
			int ny = y+dy[d];
			while(true) {
				int tx = nx+dx[d];
				int ty = ny+dy[d];
				if(tx>=0 && tx<=x && ty>=0 && ty<C) {
					if(map[tx][ty]==-1) {
						map[nx][ny]=0;
						break;
					}
					map[nx][ny] = map[tx][ty];
					nx = tx;
					ny = ty;
				}else {
					d++;
				}
			}
			
			d = 2;
			nx = x+1+dx[d]; // 공기 청정기 아래쪽 부분
			ny = y+dy[d];
			while(true) {
				int tx = nx+dx[d];
				int ty = ny+dy[d];
				if(tx>=x+1 && tx<R && ty>=0 && ty<C) {
					if(map[tx][ty]==-1) {
						map[nx][ny] = 0;
						break;
					}
					map[nx][ny] = map[tx][ty];
					nx = tx;
					ny = ty;
				}else {
					d = d==0?3:d-1;
				}
			}
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[i][j]>0) q.offer(new Dust(i,j,map[i][j]));
				}
			}
			T--;
		}
	}
}