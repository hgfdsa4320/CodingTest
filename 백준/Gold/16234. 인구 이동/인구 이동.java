import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int n,l, r;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (!check()) {
            answer++;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        findArea(i, j);
                    }
                }
            }
            if(check()){ // check함수를 통해 더이상 바꿀게 없는지 확인하고 더 바꿀 구역이 없으면 종료
                break;
            }
        }
        System.out.println(answer);
    }

    static void findArea(int x, int y) {
        visited[x][y] = true;
        List<int[]> list = new ArrayList<>(); // 구역의 x,y를 넣음
        int sum = map[x][y]; // 구역 인구수 합
        Queue<int[]> q = new LinkedList<>();
        list.add(new int[]{x, y});
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) { // 방문하지 않았고
                    int diff = Math.abs(map[x][y] - map[nx][ny]); // 인구수 차이가 L과 R 사이라면
                    if (diff >= l && diff <= r) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        sum += map[nx][ny];
                        list.add(new int[]{nx, ny});
                    }
                }
            }
        }
        for (int[] tmp : list) {
            int tx = tmp[0];
            int ty = tmp[1];
            map[tx][ty] = sum / list.size();
        }
    }
    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        int diff = Math.abs(map[i][j] - map[nx][ny]);
                        if (diff >= l && diff <= r) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}