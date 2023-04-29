import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] meetings = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            meetings[i][0]=Integer.parseInt(st.nextToken());
            meetings[i][1]=Integer.parseInt(st.nextToken());
        }
    
        Arrays.sort(meetings,(a,b)->(a[1]==b[1])?a[0]-b[0]:a[1]-b[1]);
        int endTime = 0;
        int answer = 0;
        for(int[] meeting : meetings){
            if(meeting[0]>=endTime){
                endTime=meeting[1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}