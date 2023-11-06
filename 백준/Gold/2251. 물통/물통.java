import java.io.*;
import java.util.*;

public class Main {
	static boolean[][][] visited;
	static int a, b, c, answer;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visited = new boolean[a + 1][b + 1][c + 1];
		list = new ArrayList<>();
		answer = 0;
		dfs(0, 0, c);
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}

	static void dfs(int x, int y, int z) {
		if (visited[x][y][z])
			return;
		visited[x][y][z] = true;
		if (!list.contains(z) && x==0) {
			list.add(z);
			answer++;
		}
		int[] tmp = findNum(x, y, b);
		dfs(tmp[0], tmp[1], z);
		tmp = findNum(x, z, c);
		dfs(tmp[0], y, tmp[1]);
		tmp = findNum(y, x, a);
		dfs(tmp[1], tmp[0], z);
		tmp = findNum(y, z, c);
		dfs(x, tmp[0], tmp[1]);
		tmp = findNum(z, x, a);
		dfs(tmp[1], y, tmp[0]);
		tmp = findNum(z, y, b);
		dfs(x, tmp[1], tmp[0]);
	}

	static int[] findNum(int x, int y, int t) {
		int[] arr = {x,y};
		if (x == 0 || y == t) {
			return arr;
		}
		if (x + y > t) {
			arr[0] = x + y - t;
			arr[1] = t;
		} else {
			arr[0] = 0;
			arr[1] = x + y;
		}
		return arr;
	}
}