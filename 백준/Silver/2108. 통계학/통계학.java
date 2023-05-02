import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] num = new int[8001];
        double sum=0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            num[arr[i]+4000]++;
            sum+=arr[i];
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int maxCnt=0;
        for(int i=0;i<num.length;i++){
            if(num[i]>maxCnt){
                maxCnt=num[i];
                list = new ArrayList<>();
                list.add(i-4000);
            }else if(num[i]==maxCnt){
                list.add(i-4000);
            }
        }

        System.out.println(Math.round(sum/n));
        System.out.println(arr[n/2]);
        if(list.size()>1){
            System.out.println(list.get(1));    
        }else{
            System.out.println(list.get(0));    
        }
        
        System.out.println(arr[arr.length-1]-arr[0]);
        
    }
}