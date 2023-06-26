class Solution {
    public long solution(int n) {
        long answer = 0;
        long mod=1000000007;
        long[] arr = new long[5001];
        arr[0]=1;
        arr[2]=3;
        
       for(int i=4; i<=n; i+=2){
           arr[i]= (arr[i-2]*4%mod -arr[i-4]%mod +mod)%mod;
        }
        
        return arr[n];
    }
}