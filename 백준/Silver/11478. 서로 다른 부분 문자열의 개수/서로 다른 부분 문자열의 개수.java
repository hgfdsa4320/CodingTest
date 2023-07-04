import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        Set<String> set = new HashSet<>();
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                set.add(s.substring(j,j+i));
            }
        }
        System.out.println(set.size());
    }
}