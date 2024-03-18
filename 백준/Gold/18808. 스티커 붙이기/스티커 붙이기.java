import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
 * 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다. 혜윤이는 노트북의 위쪽부터 스티커를 채워 나가려고 해서, 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다. 가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
 * 선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
 * 위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.
 */
public class Main {
	static int N, M;
	static int[][] map;
	static List<int[][]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] arr = new int[R][C];
			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < C; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			list.add(arr);
		}

		map = new int[N][M];
		for (int[][] arr : list) {
			boolean isPut = false;
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (isPossible(arr, i, j)) {
							isPut = true;
							break;
						}
					}
					if(isPut) break;
				}
				if(isPut) break;
				arr = rotate(arr);
			}

		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	static boolean isPossible(int[][] arr, int x, int y) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0 || ((i + x) < N && (j + y) < M && map[i + x][j + y] == 0)) {
					cnt++;
				}
			}
		}
		if (cnt != arr.length * arr[0].length) {
			return false;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					map[i + x][j + y] = 1;
				}
			}
		}
		return true;
	}

	static int[][] rotate(int[][] arr) {
		int[][] tmp = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				tmp[j][tmp[0].length - 1 - i] = arr[i][j];
			}
		}
		return tmp;
	}
}

/**
 * 1,3 ->0,1
 *
 * 0,0 -> 2,0
 * 0,1 -> 1,0
 * 0,2 -> 0,0
 * 1,2 -> 0,1
 * 2,2 -> 0,2
 */
/**
 * 1 0 1 0 0
 * 1 1 1 0 0
 * 0 1 0 0 0
 * 0 0 0 0 0
 */