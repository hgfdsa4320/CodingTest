import java.io.*;

public class Main{
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int len = num.length();
        int n = Integer.parseInt(num);

        int tmp = (int)Math.pow(10,len-1)-1;
        answer = (n-tmp)*len;
        if(len>1){
            dfs(len-1);
        }
        System.out.println(answer);
    }
    static void dfs(int len){
        if(len==1){
            answer+=9;
        }else{
            answer+=len*9*(int)Math.pow(10,len-1);
            dfs(len-1);
        }
    }
}