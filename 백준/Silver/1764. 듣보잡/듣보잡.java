import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(br.readLine());
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            String s = br.readLine();
            if(set.contains(s)){
                res.add(s);
            }
        }
        System.out.println(res.size());
        Collections.sort(res);
        for(String s : res){
            System.out.println(s);
        }
    }
}