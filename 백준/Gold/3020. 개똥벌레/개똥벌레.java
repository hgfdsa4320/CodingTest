import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pqTop = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqBottom = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                pqBottom.offer(Integer.parseInt(br.readLine()));
            } else {
                pqTop.offer(Integer.parseInt(br.readLine()));
            }
        }

        int min = Integer.MAX_VALUE;
        int minCount = 0;
        int cntBottom = pqBottom.size(), cntTop = 0;
        for (int height = 1; height <= h; height++) {
            while (!pqBottom.isEmpty() && pqBottom.peek() < height) {
                pqBottom.poll();
                cntBottom--;
            }
            while (!pqTop.isEmpty() && h - pqTop.peek() < height) {
                pqTop.poll();
                cntTop++;
            }
            int cnt = cntBottom + cntTop;
            if (cnt == min) {
                minCount++;
            } else if (cnt < min) {
                minCount=1;
                min = cnt;
            }
        }
        System.out.println(min+" "+minCount);
    }
}