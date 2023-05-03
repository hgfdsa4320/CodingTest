import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        int n=0;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(!s.equals("all")&&!s.equals("empty")){
                n = Integer.parseInt(st.nextToken());               
            }
            if(s.equals("add")){
                set.add(n);
            }else if(s.equals("remove")){
                if(set.contains(n)){
                    set.remove(n);
                }
            }else if(s.equals("check")){
                if(set.contains(n)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(s.equals("toggle")){
                if(set.contains(n)){
                    set.remove(n);
                }else{
                    set.add(n);
                }
            }else if(s.equals("all")){
                for(int j=1;j<=20;j++){
                    set.add(j);
                }
            }else{
                set = new HashSet<>();
            }
            
        }
        System.out.println(sb.toString());
    }
}