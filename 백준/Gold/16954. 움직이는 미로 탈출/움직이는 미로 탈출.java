import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 욱제의 캐릭터는 가장 왼쪽 아랫 칸에 있고, 이 캐릭터는 가장 오른쪽 윗 칸으로 이동해야 한다.
 * (7,0) -> (0,7)로 이동
 * bfs로 큐에 현재 위치를 넣어둠
 * visited는 3차원 배열로, x,y,시간으로 같은 시간에 같은 장소 방문하지 못하게 만듦
 * 시간이 8초가 초과하였거나(모든 벽이 없어졌거나) 도착하면 성공
 *
 * 이 게임의 특징은 벽이 움직인다는 점이다.
 * 1초마다 모든 벽이 아래에 있는 행으로 한 칸씩 내려가고, 가장 아래에 있어서 아래에 행이 없다면 벽이 사라지게 된다.
 * 욱제의 캐릭터는 1초에 인접한 한 칸 또는 대각선 방향으로 인접한 한 칸으로 이동하거나, 현재 위치에 서 있을 수 있다.
 * 이동할 때는 빈 칸으로만 이동할 수 있다.
 */
class Person{
	int x;
	int y;
	int time;

	public Person(int x, int y, int time) {
		this.x=x;
		this.y=y;
		this.time = time;
	}
}
public class Main {
	static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	static char[][] map;
	static boolean[][][] visited;
	static Queue<Person> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		map = new char[8][8];
		visited = new boolean[8][8][8];
		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		q.offer(new Person(7, 0, 0));
		visited[7][0][0] = true;
		int t = 0;
		while (t < 8) {
			Queue<Person> tmpQ = new LinkedList<>();
			while (!q.isEmpty()) {
				Person p = q.poll();
				if ((p.x == 0 && p.y == 7) || p.time >= 7) {
					//성공
					answer = 1;
					break;
				}

				// 사람 이동
				for (int i = 0; i < 9; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (isInMap(nx, ny) && map[nx][ny] == '.' && !visited[nx][ny][p.time + 1]) {
						visited[nx][ny][p.time + 1] = true;
						tmpQ.offer(new Person(nx, ny, p.time + 1));
					}
				}
			}
			if (answer == 1) {
				break;
			}
			// 벽 이동
			downWall();
			while (!tmpQ.isEmpty()) {
				Person person = tmpQ.poll();
				if (map[person.x][person.y] == '.') {
					q.offer(person);
				}
			}
			t++;

		}


		System.out.println(answer);
	}

	static void downWall() {
		for (int i = 7; i > 0; i--) {
			for (int j = 0; j < 8; j++) {
				map[i][j] = map[i - 1][j];
			}
		}
		for (int i = 0; i < 8; i++) {
			map[0][i] = '.';
		}
	}

	static boolean isInMap(int x, int y) {
		if(x>=0 && x<8 && y>=0 && y<8) return true;
		return false;
	}
}