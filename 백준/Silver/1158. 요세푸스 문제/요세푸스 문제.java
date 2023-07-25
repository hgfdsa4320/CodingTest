import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;
        while(!list.isEmpty()){
            idx = (idx+k-1>=list.size())?(idx+k-1)%list.size():idx+k-1;
            sb.append(list.get(idx));
            list.remove(idx);
            if(!list.isEmpty()){
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}