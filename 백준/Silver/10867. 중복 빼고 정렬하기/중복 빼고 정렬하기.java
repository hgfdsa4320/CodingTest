import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int[] arr = new int[set.size()];
        int idx = 0;
        for(Integer i : set){
            arr[idx++] = i;
        }
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]).append(" ");
        }


        System.out.println(sb);
    }
}