import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            String[] arrStr = tmp.replace("[","").replace("]","").split(",");
            Deque<Integer> dq = new LinkedList<>();
            for(int j=0;j<n;j++){
                dq.offer(Integer.parseInt(arrStr[j]));
            }
            boolean reverse =false;

            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='R'){
                    reverse = (reverse)? false : true;
                }else{
                    n--;
                    if(n<0){
                        break;
                    }
                    if(!reverse){
                        dq.poll();
                    }else{
                        dq.pollLast();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(!reverse){
                while(!dq.isEmpty()){
                    sb.append(dq.poll()).append(",");
                }
            }else{
                while(!dq.isEmpty()){
                    sb.append(dq.pollLast()).append(",");
                }
            }
            if(n<0) {
                System.out.println("error");
            }else if(n==0){
                System.out.println("[]");
            }else{
                System.out.println(sb.substring(0,sb.length()-1)+"]");
            }
        }

    }
}