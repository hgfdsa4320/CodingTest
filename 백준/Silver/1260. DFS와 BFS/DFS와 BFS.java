import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(map[i]);
        }
        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);
    }
    static void dfs(int v){
        visited[v] = true;
        System.out.print(v+" ");
        for(int i=0;i<map[v].size();i++){
            int tmp = map[v].get(i);
            if(!visited[tmp]){
                dfs(tmp);
            }
        }
    }
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.offer(v);

        while(!q.isEmpty()){
            v = q.poll();
            System.out.print(v+" ");
            for(int i=0;i<map[v].size();i++){
                int tmp = map[v].get(i);
                if(!visited[tmp]){
                    visited[tmp] = true;
                    q.offer(tmp);
                }
            }
        }
    }
}