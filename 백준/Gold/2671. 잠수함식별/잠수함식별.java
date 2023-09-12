import java.io.*;

public class Main {
	static boolean res;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		find(s);
		if(res) System.out.println("SUBMARINE");
		else System.out.println("NOISE");
	}
	static void find(String s) {
		if(s.charAt(0)=='1') { // 첫째 수를 기준으로 나눔
			if(s.length()<4) return;
			if(s.charAt(1)=='1' || s.charAt(2)=='1') return;
			int j=3;
			while(j<s.length()) {
				if(s.charAt(j)=='1') {
					if(j==s.length()-1) {
						res = true;
						return;
					}else {
						while(j<s.length() && s.charAt(j)=='1') {
							if(j==s.length()-1) {
								res = true;
								return;
							}
							find(s.substring(j+1));
							j++;
							if(s.charAt(j)=='0') return;
						}
						
					}
				}else {
					j++;
				}
			}
		}else { //첫째 수가 0일때 길이가 2 이하거나, 2번째수가 1이아니면 리턴
			if(s.length()<2) return;
			if(s.charAt(1)=='1') {
				if(s.length()==2) {
					res = true;
					return;
				}else {
					find(s.substring(2));
				}
			}
		}
	}
}