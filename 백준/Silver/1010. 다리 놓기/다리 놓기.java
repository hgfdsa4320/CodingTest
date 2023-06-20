import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int t=0;t<n;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==0){
                System.out.println(0);
                continue;
            } else if (a == b) {
                System.out.println(1);
                continue;
            }
            a = Math.min(a, b - a);

            long answer = 1;
            int cnt = a;
            for(int i=1;i<=cnt;i++){
                answer*=b--;
            }
            for(int i=1;i<=cnt;i++){
                answer/=a--;

            }
            System.out.println(answer);
        }
    }
}