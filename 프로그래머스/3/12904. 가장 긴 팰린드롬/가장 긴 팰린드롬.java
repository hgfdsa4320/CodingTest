/*
9,000,000
*/


class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        //팰린드롬이 홀수일 경우
        for(int i=1;i<s.length()-1;i++){
            int d = 1;
            int len = 1;
            while(i-d>=0 && i+d<s.length()){
                if(s.charAt(i-d) != s.charAt(i+d)){
                    break;
                }
                len+=2;
                d++;
            }
            answer = Math.max(answer,len);
        }
        
        for(int i=0;i<s.length()-1;i++){
            int j = i+1;
            if(s.charAt(i)==s.charAt(j)){
                int d = 1;
                int len = 2;
                while(i-d>=0 && j+d<s.length()){
                    if(s.charAt(i-d)!=s.charAt(j+d)){
                        break;
                    }
                    len+=2;
                    d++;
                }
                answer = Math.max(answer,len);
            }
        }
        return answer;
    }
}