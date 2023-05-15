class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        
        int len = number.length()-k;
        int index = 0;
        for(int i=0;i<len;i++){
            int max = 0;
            
            for(int j=index;j<=k+i;j++){
                if(number.charAt(j)-'0'>max){
                    index = j+1;
                    max = number.charAt(j)-'0';
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
 
}