import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] distance = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			distance[a][b] = Math.min(distance[a][b], c);
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(i!=k) {
					for(int j=1;j<=n;j++) {
						if(j!=i && j!=k) {
							if(distance[i][k]!=Integer.MAX_VALUE && distance[k][j]!=Integer.MAX_VALUE) {
								distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);	
							}
							
						}
					}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(distance[i][j]==Integer.MAX_VALUE) {
					System.out.print(0+" ");
				}else {
					System.out.print(distance[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}