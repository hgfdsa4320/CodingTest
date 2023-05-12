import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] arr = {'A','C','G','T'};
        int[] cnt = new int[4]; 
        int[] dna = new int[4];
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            dna[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int answer = 0;
        Loop1:
        for(int end=0;end<s;end++){
            for(int i=0;i<4;i++){
                if(str.charAt(end)==arr[i]){
                    cnt[i]++;
                    break;
                }
            }
            if(end>=p){   
                for(int i=0;i<4;i++){
                    if(str.charAt(start)==arr[i]){
                        cnt[i]--;
                        break;
                    } 
                }
                start++; 
            }
            if(end>=p-1){
                for(int i=0;i<4;i++){
                    if(cnt[i]<dna[i]){
                        continue Loop1;
                    }
                }
                answer++;
            }

            
        }
        System.out.println(answer);
    }
}