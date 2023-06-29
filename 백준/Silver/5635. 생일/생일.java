import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            String birth = tmp[3];
            if(Integer.parseInt(tmp[2])<10){
                birth+="0"+tmp[2];
            }else{
                birth+=tmp[2];
            }
            if(Integer.parseInt(tmp[1])<10){
                birth+="0"+tmp[1];
            }else{
                birth+=tmp[1];
            }
            list.add(new String[]{tmp[0],birth});
        }
        Collections.sort(list,(a,b)->Integer.parseInt(a[1])-Integer.parseInt(b[1]));
        System.out.println(list.get(list.size()-1)[0]);
        System.out.println(list.get(0)[0]);
    }
}