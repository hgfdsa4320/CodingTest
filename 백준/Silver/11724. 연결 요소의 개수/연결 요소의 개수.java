import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static ArrayList<Integer> arr[];
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                cnt++;;
                dfs(i);
            }
        }
        System.out.println(cnt);
        
    }
    
    static void dfs(int v){
        visited[v]=true;
        for(int i=0;i<arr[v].size();i++){
            int tmp = arr[v].get(i);
            if(!visited[tmp]){
                dfs(tmp);
            }
        }
    }
}