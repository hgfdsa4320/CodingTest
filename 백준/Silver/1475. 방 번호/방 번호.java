import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        while(n>0){
            int tmp = n%10;
            n/=10;
            if(tmp==9){
                arr[6]++;
            }
            else{
                arr[tmp]++;
            }
        }
        arr[6]= (arr[6]%2==0)?arr[6]/=2:arr[6]/2+1;
        int max=0;
        for(int i=0;i<10;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);
    }
}