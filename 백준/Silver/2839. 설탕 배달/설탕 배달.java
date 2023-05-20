import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n*2];
        arr[3]=arr[5]=1;
        for(int i=6;i<=n;i++){
            if(arr[i-3]!=0){
                arr[i]=arr[i-3]+1;
            }
            if(arr[i-5]!=0){
                if(arr[i]!=0){
                    arr[i]=Math.min(arr[i],arr[i-5]+1);
                }else{
                    arr[i]=arr[i-5]+1;
                }
            }
        }
        if(arr[n]==0){
            System.out.println(-1);
        }else{
            System.out.println(arr[n]);
        }
    }
}