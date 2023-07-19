import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")){
                int value = Integer.parseInt(st.nextToken());
                dq.offer(value);
            }else if(order.equals("pop")){
                if(dq.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                	sb.append(dq.pop()).append("\n");
                }
            }else if(order.equals("size")){
            	sb.append(dq.size()).append("\n");
            }else if(order.equals("empty")){
                if(dq.isEmpty()){
                	sb.append(1).append("\n");
                }else{
                	sb.append(0).append("\n");
                }
            }else if(order.equals("front")){
                if(dq.isEmpty()){
                	sb.append(-1).append("\n");
                }else{
                	sb.append(dq.peek()).append("\n");
                }
            }else if(order.equals("back")){
                if(dq.isEmpty()){
                	sb.append(-1).append("\n");
                }else{
                	sb.append(dq.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}