import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        boolean[] arr =new boolean[10000001];

        for(int i=2;i<Math.sqrt(arr.length);i++){
            if(arr[i]==true) continue;
            for(int j=i+i;j<arr.length;j+=i){
                arr[j] = true;
            }
        }

        int answer = 0;

        for(int i=2;i<arr.length;i++){
            if(!arr[i]){
                long tmp = i;
                while((double)i <= (double)b/tmp){
                    if((double)i >= (double)a/tmp){
                        answer++;
                    }
                    tmp *= i;
                }

            }

        }
        System.out.println(answer);
    }
}