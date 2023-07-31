import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n = 19;
	static int win = 0;
	static int[][] arr;
	static int[] res = new int[2];
	public static void main(String[] args) throws Exception {
//		//////////////////////////////////////////////////////////////
//		// 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
//		//////////////////////////////////////////////////////////////
//		System.setIn(new FileInputStream("Test5.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Loop1:
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]!=0) {
					if(checkRight(i,j)||checkDown(i,j)||checkDagakRight(i,j)||checkDagakLeft(i,j)) {
						win = arr[i][j];
						break Loop1;
					}
				}
			}
		}
		System.out.println(win);
		if(win!=0) {
			System.out.println(res[0]+" "+res[1]);			
		}

		
		
		
	}
	static boolean checkRight(int x, int y) {
		int tmp = arr[x][y];
		int prevY = y-1;
		if(prevY>=0 && arr[x][prevY]==tmp) {
			return false;
		}
		int tmpY = y;
		int cnt= 1;
		while(true) {
			tmpY +=1;
			if(tmpY<n && arr[x][tmpY]==tmp) {
				cnt++;
			}else {
				break;
			}
		}
		if(cnt==5) {
			res[0] = x+1;
			res[1] = y+1;
			return true;
		}
		return false;
	}
	static boolean checkDown(int x, int y) {
		int tmp = arr[x][y];
		int prevX = x-1;
		if(prevX>=0 && arr[prevX][y]==tmp) {
			return false;
		}
		int tmpX = x;
		int cnt= 1;
		while(true) {
			tmpX +=1;
			if(tmpX<n && arr[tmpX][y]==tmp) {
				cnt++;
			}else {
				break;
			}
		}
		if(cnt==5) {
			res[0] = x+1;
			res[1] = y+1;
			return true;
		}
		return false;
		
	}
	static boolean checkDagakRight(int x, int y) { //오른쪽 아래 대각선 확인
		int tmp = arr[x][y];
		int prevX = x-1;
		int prevY = y-1;
		if(prevX>=0 && prevY>=0 && arr[prevX][prevY]==tmp) {
			return false;
		}
		int tmpX = x;
		int tmpY = y;
		int cnt= 1;
		while(true) {
			tmpX +=1;
			tmpY +=1;
			if(tmpX<n && tmpY<n && arr[tmpX][tmpY]==tmp) {
				cnt++;
			}else {
				break;
			}
		}
		if(cnt==5) {
			res[0] = x+1;
			res[1] = y+1;
			return true;
		}
		return false;
		
	}
	static boolean checkDagakLeft(int x, int y) { //왼쪽 아래 대각선 확인
		int tmp = arr[x][y];
		int prevX = x-1;
		int prevY = y+1;
		if(prevX>=0 && prevY<n && arr[prevX][prevY]==tmp) {
			return false;
		}
		int tmpX = x;
		int tmpY = y;
		int cnt= 1;
		while(true) {
			tmpX +=1;
			tmpY -=1;
			if(tmpX<n && tmpY>=0 && arr[tmpX][tmpY]==tmp) {
				cnt++;
			}else {
				break;
			}
		}
		if(cnt==5) {
			res[0] = x+5;
			res[1] = y-3;
			return true;
		}
		return false;
	}
}

