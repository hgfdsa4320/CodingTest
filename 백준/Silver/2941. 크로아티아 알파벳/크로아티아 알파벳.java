import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int i=0,cnt=0;
        while (i<str.length()){
            if(str.charAt(i)=='c'){
                if(i<str.length()-1&&(str.charAt(i+1)=='='||str.charAt(i+1)=='-')){
                    i+=2;
                }else
                    i+=1;
            }else if(str.charAt(i)=='d'){
                if(i<str.length()-2&&str.charAt(i+1)=='z'&&str.charAt(i+2)=='='){
                    i+=3;
                }else if (str.charAt(i)=='d'){
                if(i<str.length()-1&&str.charAt(i+1)=='-'){
                    i+=2;
                }else
                    i+=1;
                }
                
            }else if(str.charAt(i)=='l'||str.charAt(i)=='n'){
                if(i<str.length()-1&&str.charAt(i+1)=='j'){
                    i+=2;
                }else
                    i+=1;
            }else if(str.charAt(i)=='s'||str.charAt(i)=='z'){
                if(i<str.length()-1&&str.charAt(i+1)=='='){
                    i+=2;
                }else
                    i+=1;
            }else{
                i+=1;
            }
            cnt+=1;
        }
        System.out.println(cnt);
    }
}