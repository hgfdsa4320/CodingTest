import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tree{
	int x;
	int y;
	int age;

	public Tree(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}

	public String toString() {
		return x + " " + y + " " + age;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] nutrition;
	static List<Tree> trees = new ArrayList<>();
	static Queue<Tree> dieTrees = new LinkedList<>();
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		nutrition = new int[N + 1][N + 1];
		// 양분 5로 초기화
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], 5);
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				nutrition[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())));
		}


		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(trees.size());
	}

	static void spring() {
		List<Tree> remains = new ArrayList<>();
		for (int i = 0; i < trees.size(); i++) {
			Tree tree = trees.get(i);
			if (map[tree.x][tree.y] < tree.age) {
				dieTrees.add(tree);
			} else {
				map[tree.x][tree.y] -= tree.age;
				tree.age++;
				remains.add(tree);
			}
		}
		trees = remains;
	}

	static void summer() {
		while (!dieTrees.isEmpty()) {
			Tree tree = dieTrees.poll();
			map[tree.x][tree.y] += tree.age / 2;
		}
	}

	static void fall() {
		List<Tree> newTrees = new ArrayList<>();
		for (int i = 0; i < trees.size(); i++) {
			Tree tree = trees.get(i);
			if (tree.age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int nx = tree.x + dx[j];
					int ny = tree.y + dy[j];
					if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
						newTrees.add(new Tree(nx, ny, 1));
					}
				}
			}
		}
		for (int i = 0; i < trees.size(); i++) {
			newTrees.add(trees.get(i));
		}
		trees = newTrees;
	}

	static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += nutrition[i][j];
			}
		}
	}

}