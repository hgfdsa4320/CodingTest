import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 그룹 클래스를 만든다.그룹 클래스에 소속된 블록의 리스트, 기준 블록의 행열 정보 기록
 * 2. bfs 탐색하며 블록 그룹을 모두 pq에 넣어두자 -> 0에 대해 방문 처리 확인
 * 3. pq에서 뺀 블록 그룹에 대해 작업을 진행한다.
 */

class Group {
    List<int[]> blockList;
    int rainbowNum;
    int baseX;
    int baseY;

    public Group(List<int[]> blockList, int rainbowNum, int baseX, int baseY) {
        this.blockList = blockList;
        this.rainbowNum = rainbowNum;
        this.baseX = baseX;
        this.baseY = baseY;
    }
}
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static PriorityQueue<Group> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //크기가 가장 큰 블록 그룹을 찾는다. 그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹,
        // 그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을, 그 것도 여러개이면 열이 가장 큰 것을 찾는다.

        int answer = 0;
        while (true) {
            pq = new PriorityQueue<>((a, b) -> a.blockList.size() == b.blockList.size() ? (a.rainbowNum == b.rainbowNum ? (a.baseX == b.baseX ? b.baseY - a.baseY : b.baseX - a.baseX) : b.rainbowNum - a.rainbowNum) : b.blockList.size() - a.blockList.size());
            //그룹 찾기
            visited = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > 0 && visited[i][j] == 0) {
                        findGroup(i, j);
                    }
                }
            }
            // 더이상 그룹이 없으면 종료
            if(pq.size()==0) break;

            Group g = pq.poll();
            //한 그룹 제거
            answer += Math.pow(g.blockList.size(), 2);
            removeGroup(g);
            //격자에 중력 작용
            gravityMap();
            //격자가 90도 반시계 회전
            rotateMap();
            // 격자에 중력 작용
            gravityMap();
        }

        System.out.println(answer);

    }

    static void findGroup(int x, int y) {
        List<int[]> blockList = new ArrayList<>();
        int rainbowNum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = 1;
        blockList.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int nowX = q.peek()[0];
            int nowY = q.poll()[1];
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                    if (map[nx][ny] == map[x][y] && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                        blockList.add(new int[]{nx, ny});
                    } else if (map[nx][ny] == 0 && visited[nx][ny] != map[x][y]) {
                        visited[nx][ny] = map[x][y];
                        q.offer(new int[]{nx, ny});
                        blockList.add(new int[]{nx, ny});
                        rainbowNum++;
                    }
                }
            }
        }

        if (blockList.size() > 1) {
            pq.offer(new Group(blockList, rainbowNum, x, y));
        }
    }

    static void removeGroup(Group group) {
        List<int[]> blockList = group.blockList;
        for (int i = 0; i < blockList.size(); i++) {
            int x = blockList.get(i)[0];
            int y = blockList.get(i)[1];
            map[x][y] = -2;
        }
    }

    static void gravityMap() {
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] >= 0 && map[i+1][j]==-2) { //밑으로 옮겨야 된다면
                    int idx = i;
                    while (true) {
                        idx += 1;
                        if (idx > N || map[idx][j] != -2) {
                            break;
                        }
                    }
                    map[idx-1][j] = map[i][j];
                    map[i][j] = -2;
                }
            }
        }
    }

    static void rotateMap() {
        int[][] tmpMap = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tmpMap[N - j + 1][i] = map[i][j];
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = tmpMap[i][j];
            }
        }
    }
}