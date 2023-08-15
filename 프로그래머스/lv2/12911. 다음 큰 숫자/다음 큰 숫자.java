class Solution {
    public int solution(int n) {
        String tmp = Integer.toString(n,2);
        tmp = tmp.replace("0","");
        int cnt = tmp.length();
        while(true){
            n++;
            String s = Integer.toString(n,2);
            s = s.replace("0","");
            if(s.length()==cnt){
                break;
            }
        }
        return n;
    }
}