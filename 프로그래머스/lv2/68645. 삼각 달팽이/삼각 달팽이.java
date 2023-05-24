class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,-1,-1};
    static int d;
    static int size;
    static int[][] arr;
    public int[] solution(int n) {
        
        arr = new int[n][];
        size=0;
        for(int i=0;i<n;i++){
            arr[i] = new int[i+1];
            size+=i+1;
        }
        int[] answer = new int[size];
        d=0;
        int cnt=1;
        int x = 0;
        int y = 0;
        arr[x][y] = cnt++;
        size--;
                
        while(size>0){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[nx].length && arr[nx][ny]==0){
                arr[nx][ny]=cnt++;
                size--;
                x = nx;
                y = ny;
            }else{
                d = (d+1)%4;
            }
        }
        
        int idx=0;
       
        for(int i=0;i<n;i++){
            for(int j=0;j<arr[i].length;j++){
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
    
}