import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(true){
            if(isPalindrome(n) && isPrime(n)){
                System.out.println(n);
                break;
            }
            n++;
        }
    }
    static boolean isPalindrome(int n){
        String num = String.valueOf(n);
        int left = 0;
        int right = num.length()-1;
        while(left<right){
            if(num.charAt(left)==num.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
    
    static boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}