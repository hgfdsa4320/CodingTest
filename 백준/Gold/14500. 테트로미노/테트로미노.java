import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n,m;
    static boolean[][] visited;
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) { //1,3,4 번 해결
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                findNum(1, arr[i][j], i, j);
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < n - 1; i++) { //2번 해결
            for (int j = 0; j < m - 1; j++) {
                int tmp = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                answer = Math.max(answer, tmp);
            }
        }

        //5번 4방향
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-2; j++) {
                int tmp = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i][j + 2];
                answer = Math.max(answer, tmp);
            }
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < m-2; j++) {
                int tmp = arr[i][j] + arr[i + 1][j + 1] + arr[i + 1][j] + arr[i+1][j - 1];
                answer = Math.max(answer, tmp);
            }
        }
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-1; j++) {
                int tmp = arr[i][j] + arr[i+1][j] + arr[i + 1][j + 1] + arr[i+2][j];
                answer = Math.max(answer, tmp);
            }
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                int tmp = arr[i][j] + arr[i - 1][j + 1] + arr[i][j + 1] + arr[i + 1][j + 1];
                answer = Math.max(answer, tmp);
            }
        }

        System.out.println(answer);
    }
    static void findNum(int cnt, int sum, int x, int y) {
        if (cnt == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                findNum(cnt + 1, sum + arr[nx][ny], nx, ny);
                visited[nx][ny] = false;
            }
        }

    }
}