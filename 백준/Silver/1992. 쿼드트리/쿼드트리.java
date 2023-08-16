import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

	    for(int i=0;i<n;i++){
	        String s = br.readLine();
	        for (int j = 0; j < n; j++) {
	            arr[i][j] = s.charAt(j) - '0';
	        }
	    }
	    changeMin(0, 0, n);
	    Stack<Character> st = new Stack<>();
	    
//	    for(int i=0;i<sb.length();i++) {
//	    	if(sb.charAt(i)==')') {
//	    		char[] tmp = new char[4]; // 숫자 4개가 같은지 확인 할 배열
//	    		int idx  =0;
//	    		tmp[idx++] = st.pop();
//	    		while(!st.isEmpty() && st.peek()==tmp[0]) {
//	    			tmp[idx++] = st.pop();
//	    		}
//	    		if(idx==4) { //4개가 다 같을 경우
//	    			st.pop(); //여는 괄호 빼줌
//	    			st.push(tmp[0]); // 숫자 넣어줌
//	    		}else {
//	    			while(idx>0) {
//	    				st.push(tmp[--idx]); //원복 시켜줌
//	    			}
//	    			st.push(')');
//	    		}
//	    	}else {
//	    		st.push(sb.charAt(i));
//	        		
//	    	}
//	    }
//	    sb= new StringBuilder();
//	    while(!st.isEmpty()) {
//	    	sb.append(st.pop());
//	    }
	    System.out.println(sb); //stack이므로 뒤집어줌
//	    System.out.println(sb.toString().equals("((1010)(1010)(1010)(1010))"));
    }
    
    
    
	static void changeMin(int x, int y, int n) {
		int tmp = arr[x][y];
		for (int i = x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(arr[i][j] != tmp) {
					tmp = -1;
					break;
				}
			}
		}
		if(tmp==-1) {
		    sb.append("(");
		    changeMin(x, y, n / 2);
		    changeMin(x, y + n / 2, n / 2);
		    changeMin(x + n / 2, y, n / 2);
		    changeMin(x + n / 2, y + n / 2, n / 2);
		    sb.append(")");
		}else {
			sb.append(tmp);
		}
	    

	}
}