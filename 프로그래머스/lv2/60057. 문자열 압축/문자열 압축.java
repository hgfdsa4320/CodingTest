class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int n = s.length();
        if(s.length()==1) return 1;
        for(int i=1;i<=n/2;i++){
            int idx=0;
            int cnt=1;
            String tmp = s.substring(idx,idx+i);
            StringBuilder sb = new StringBuilder();
            while(idx+i*2<=n){
                if(tmp.equals(s.substring(idx+i,idx+i*2))){
                    cnt++;
                }else{
                    if(cnt>1){
                        sb.append(cnt); 
                    }
                    sb.append(tmp);
                    tmp = s.substring(idx+i,idx+i*2);
                    cnt=1;
                }
                idx+=i;

            }
            if(cnt>1){
                sb.append(cnt);
            }
            sb.append(tmp);
            idx+=i;
            if(idx<n){
                sb.append(s.substring(idx));
            }
            
            answer = Math.min(answer,sb.length());
        }
        return answer;
    }
}