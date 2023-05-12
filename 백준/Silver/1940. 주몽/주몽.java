import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i]=tmp;
            set.add(tmp);
        }
        int answer=0;
        for(int i : arr){
            if(set.contains(m-i)){
                answer++;
            }
        }
        System.out.println(answer/2);
    }
}