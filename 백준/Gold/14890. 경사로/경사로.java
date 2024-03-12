import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int[] now = new int[]{map[i][0], 1, 0};
            boolean isPossible = true;
            for (int j = 1; j < N; j++) {
                if (map[i][j] == now[0]) { // 높이가 같을 경우
                    now[1]++;
                    if (now[2] > 0) {
                        now[2]--;
                        if (now[2] == 0) {
                            now[1] -= L;
                        }
                    }
                } else if (Math.abs(map[i][j] - now[0]) > 1) {
                    isPossible = false;
                    break;
                } else { // 높이가 다를 경우
                    if (now[2] > 0) { // 경사면 중간에 다른 경사면 놓지 못함
                        isPossible = false;
                        break;
                    }
                    if (now[0] < map[i][j]) {
                        if (now[1] >= L) {
                            now[0] = map[i][j];
                            now[1] = 1;
                        }else {
                            isPossible = false;
                            break;
                        }
                    } else {
                        now[0] = map[i][j];
                        now[1] = 1;
                        if (L == 1) {
                            now[1] = 0;
                        }
                        now[2] = L - 1;
                    }
                }
            }
            if (isPossible && now[2] == 0) {
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            int[] now = new int[]{map[0][i], 1, 0};
            boolean isPossible = true;
            for (int j = 1; j < N; j++) {
                if (map[j][i] == now[0]) { // 높이가 같을 경우
                    now[1]++;
                    if (now[2] > 0) {
                        now[2]--;
                        if (now[2] == 0) {
                            now[1] -= L;
                        }
                    }
                } else if (Math.abs(map[j][i] - now[0]) > 1) {
                    isPossible = false;
                    break;
                } else { // 높이가 다를 경우
                    if (now[2] > 0) { // 경사면 중간에 다른 경사면 놓지 못함
                        isPossible = false;
                        break;
                    }
                    if (now[0] < map[j][i]) {
                        if (now[1] >= L) {
                            now[0] = map[j][i];
                            now[1] = 1;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else {
                        now[0] = map[j][i];
                        now[1] = 1;
                        if (L == 1) {
                            now[1] = 0;
                        }
                        now[2] = L - 1;
                    }
                }
            }
            if (isPossible && now[2] == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}