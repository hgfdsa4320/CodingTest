import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer,int[]> map;
	static int[][] result;
	static int[][][] arr;
	static boolean[] isPossible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[4][6][3];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		isPossible = new boolean[4];
		result = new int[6][3];
		map = new HashMap<>();
		map.put(0, new int[] {0, 1});
		map.put(1, new int[] {0, 2});
		map.put(2, new int[] {0, 3});
		map.put(3, new int[] {0, 4});
		map.put(4, new int[] {0, 5});
		map.put(5, new int[] {1, 2});
		map.put(6, new int[] {1, 3});
		map.put(7, new int[] {1, 4});
		map.put(8, new int[] {1, 5});
		map.put(9, new int[] {2, 3});
		map.put(10, new int[] {2, 4});
		map.put(11, new int[] {2, 5});
		map.put(12, new int[] {3, 4});
		map.put(13, new int[] {3, 5});
		map.put(14, new int[] {4, 5});
		findIsPossible(0);
		for (int i = 0; i < 4; i++) {
			if (isPossible[i]) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}
	}

	static void findIsPossible(int cnt) {
		if (cnt == 15) {
			// System.out.println(Arrays.deepToString(result));
			for (int i = 0; i < 4; i++) {
				if(isPossible[i])
					continue;
				boolean isOkay = true;
				for (int j = 0; j < 6; j++) {
					for (int k = 0; k < 3; k++) {
						if (result[j][k] != arr[i][j][k]) {
							isOkay = false;
							break;
						}
					}
					if (!isOkay) {
						break;
					}
				}
				if (isOkay) {
					isPossible[i] = true;
				}
			}
			return;
		}
		int[] tmp = map.get(cnt);
		int a = tmp[0];
		int b = tmp[1];
		result[a][0]++;
		result[b][2]++;
		findIsPossible(cnt + 1);
		result[a][0]--;
		result[b][2]--;
		result[a][1]++;
		result[b][1]++;
		findIsPossible(cnt + 1);
		result[a][1]--;
		result[b][1]--;
		result[a][2]++;
		result[b][0]++;
		findIsPossible(cnt + 1);
		result[a][2]--;
		result[b][0]--;
	}
}