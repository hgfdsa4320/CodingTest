import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 1;
        int start = 1;
        int end = 2;
        int sum = start+end;
        while(end<n){
            if(sum==n){
                answer++;
                sum-=start++;
                sum+=++end;
            }else if(sum<n){
                sum+=++end;
            }else{
                sum-=start++;
            }
        }
        System.out.println(answer);
    }
}