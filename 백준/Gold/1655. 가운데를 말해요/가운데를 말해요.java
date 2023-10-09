import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();
        int mid = Integer.parseInt(br.readLine());
        sb.append(mid);
        for(int i=1;i<n;i++) {
            int now = Integer.parseInt(br.readLine());
            if (now <= mid) {
                pqLeft.offer(now);
                if (pqLeft.size() - pqRight.size() >= 1) {
                    pqRight.offer(mid);
                    mid = pqLeft.poll();

                }
            } else {
                pqRight.offer(now);
                if (pqRight.size() - pqLeft.size() == 2) {
                    pqLeft.offer(mid);
                    mid = pqRight.poll();
                }
            }
            sb.append("\n").append(mid);
        }
        System.out.print(sb);
    }
}