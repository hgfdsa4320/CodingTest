import java.io.*;
import java.util.*;

public class Main{
    static boolean[] checked;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        checked = new boolean[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 1; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        dfs(v);
        checked = new boolean[n+1];
        System.out.println();
        bfs(v);
    }
    static void dfs(int v){
        checked[v]=true;
        System.out.print(v+" ");
        for(int i=0;i<arr[v].size();i++){
            int tmp = arr[v].get(i);
            if(!checked[tmp]){
                dfs(tmp);
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        checked[v]=true;
        q.offer(v);

        while(!q.isEmpty()){
            int tmp = q.poll();
            System.out.print(tmp+" ");
            for (int i = 0; i < arr[tmp].size(); i++) {
                if(!checked[arr[tmp].get(i)]){
                    checked[arr[tmp].get(i)]=true;
                    q.offer(arr[tmp].get(i));
                }
            }

        }
    }
}