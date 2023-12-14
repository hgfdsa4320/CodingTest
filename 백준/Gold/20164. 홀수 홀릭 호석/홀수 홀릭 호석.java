import java.io.*;
import java.util.*;

public class Main {
    static int min,max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        max = 0;
        min = Integer.MAX_VALUE;
        findNum(n,cntOdd(n));
        System.out.println(min+" "+max);
    }

    static void findNum(String n,int cnt) {
        if (n.length() == 1) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }
        if (n.length() == 2) {
            String next = String.valueOf(n.charAt(0)-'0'+n.charAt(1)-'0');
            findNum(next,cnt+cntOdd(next));
        }
        else{
            int len = n.length();
            for (int i = 1; i < len - 1; i++) {
                String s1 = n.substring(0, i);
                for (int j = i + 1; j < len ; j++) {
                    String s2 = n.substring(i, j);
                    String s3 = n.substring(j);
                    String next = String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3));
                    findNum(next,cnt+cntOdd(next));
                }
            }

        }
    }

    static int cntOdd(String n) {
        int cnt =0;
        for (int i = 0; i < n.length(); i++) {
            if ((n.charAt(i) - '0') % 2 == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}