import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] adjArr = new ArrayList[v+1];
        for(int i=1;i<=v;i++) {
            adjArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adjArr[a].add(new int[] {b,c});
        }
        int[] distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 현재 위치, 거리
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[] { k, 0 });
        distance[k] = 0;

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int now = tmp[0];
            int dist = tmp[1];
            
            for(int j=0;j<adjArr[now].size();j++) { // 인접 리스트의 크기만큼 반복
                int tmpDist = dist + adjArr[now].get(j)[1];
                int tmpNode = adjArr[now].get(j)[0];
                if (tmpDist < distance[tmpNode]) {
                    distance[tmpNode] = tmpDist;
                    pq.offer(new int[] {tmpNode,tmpDist});
                }
            }
        }
        for(int i=1;i<=v;i++) {
            if(distance[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}