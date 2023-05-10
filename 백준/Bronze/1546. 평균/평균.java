import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[n];
        int max = 0;
        
        for(int i=0;i<n;i++){
            scores[i] = Integer.parseInt(st.nextToken());
            if(scores[i]>max) max = scores[i];
        }
        double sum = 0;
        for(int i=0;i<n;i++){
            sum+=(double)scores[i]/max*100;
        }
        System.out.println(sum/n);
    }
}