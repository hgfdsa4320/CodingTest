import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque dq = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                dq.offerFirst(x);
            } else if (order.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                dq.offer(x);
            }else if (order.equals("pop_front")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.poll());
                }
            }else if (order.equals("pop_back")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.pollLast());
                }
            }else if (order.equals("size")) {
                System.out.println(dq.size());
            }else if (order.equals("empty")) {
                if (dq.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }else if (order.equals("front")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.peek());
                }
            }else if (order.equals("back")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.peekLast());
                }
            }
        }
    }
}