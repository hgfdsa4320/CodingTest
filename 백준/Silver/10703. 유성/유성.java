import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][s];
		
		List<int[]> star =new ArrayList<>();
		List<int[]> ground =new ArrayList<>();
		Map<Integer,Integer> highMap = new HashMap<>(); //해당 인덱스에서 가장 높은 유성 높이를 저장 
		int[] lowGround = new int[s]; //땅 높이중 가장 낮은 높이를 저장
		Arrays.fill(lowGround,Integer.MAX_VALUE);
		int minX=Integer.MAX_VALUE;
		int maxX=0;
		for(int i=0;i<r;i++) {
			String tmp = br.readLine();
			for(int j=0;j<s;j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='X') {
					minX = Math.min(minX,i);
					maxX = Math.max(maxX,i);
					star.add(new int[] {i,j});
					if(highMap.containsKey(j)) {
						highMap.put(j,Math.max(highMap.get(j),i));
					}else {
						highMap.put(j,i);
					}
				}else if(map[i][j]=='#') {
					ground.add(new int[] {i,j});
					lowGround[j] = Math.min(lowGround[j],i);
				}
			}
		}
		int max = Integer.MAX_VALUE;//땅과 유성의 최대 높이차
		for(Integer key : highMap.keySet()) {
			max = Math.min(max,lowGround[key]-highMap.get(key)-1);
		}
		
		char[][] answer = new char[r][s];
		for(int i=0;i<r;i++) {
			for(int j=0;j<s;j++) {
				answer[i][j] = '.';
			}
		}
		for(int i=0;i<star.size();i++) {
			int x = star.get(i)[0];
			int y = star.get(i)[1];
			answer[x+max][y] = 'X';
		}
		for(int i=0;i<ground.size();i++) {
			int x = ground.get(i)[0];
			int y = ground.get(i)[1];
			answer[x][y] = '#';
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<r;i++) {
			for(int j=0;j<s;j++) {
				sb.append(answer[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}