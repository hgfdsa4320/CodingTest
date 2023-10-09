import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n+1];
        Map<Long, Long> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            arr[i] += arr[i-1] + Long.parseLong(st.nextToken());
        }
        long answer = 0;
        for(int i=1;i<=n;i++){
            arr[i] = arr[i]%m;
            map.put(arr[i],map.getOrDefault(arr[i],0L)+1);
        }
        if(map.containsKey(0L)){
            answer += map.get(0L);
        }
        for(Long key : map.keySet()){
            long cnt = map.get(key);
            if(cnt>=2){
                answer += (cnt*(cnt-1))/2;
            }
        }
        System.out.println(answer);
    }
}