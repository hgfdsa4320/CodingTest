class Solution {
    public long solution(int w, int h) {
        
        double a = (double)w/h; //기울기
        int b = gcd(w,h); // w,h의 최대 공약수
        double previous = 0;
        long cnt=0;
        for(int i=1;i<=h/b;i++){
            double now = a*i;
            long tmp = (long)now;
            // if(now-tmp==0){ // 중간에 꼭지점 만나면 
            //     System.out.println(i+" " + cnt);
            //     cnt+=(long)now-(long)previous;
            //     cnt*=(h/b)/i; //현재 개수 * 남은 길이
            //     System.out.println(cnt);
            //     break;
            // }
            cnt+=(long)now-(long)previous+1;
            previous = now;
            
        }
        cnt--;
        long answer = (long)w*h-cnt*b;
        return answer;
    }
    
    static int gcd(int a, int b){
        if(b>a){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b==0) return a;
        return gcd(b,a%b);
    }
}