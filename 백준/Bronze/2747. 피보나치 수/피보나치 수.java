import java.io.*;

public class Main {
	static int[] memo;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		memo = new int[n+1];
		System.out.println(fibo(n));
	}
	static int fibo(int n) {
		if(n<=1) return n;
		if(memo[n] ==0) {
			memo[n] = fibo(n-1)+fibo(n-2);
		}
		return memo[n];
	}
}