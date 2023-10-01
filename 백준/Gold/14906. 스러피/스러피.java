import java.io.*;
public class Main {
    static int idx;
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("SLURPYS OUTPUT");
        for (int i = 0; i < n; i++) {
            flag = false;
            idx = 0;
            String s = br.readLine();
            visited = new boolean[s.length()];
            boolean isSlurpy = false;
            if (isSlimp(s)) {
                if (isSlump(s.substring(idx))) {
                    isSlurpy = true;
                }
            }
            if (isSlurpy) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        System.out.println("END OF OUTPUT");
    }

    static boolean isSlump(String s) {
        //스럼프
        //조건 1
        if (s.length()>2 && (s.charAt(0) == 'D' || s.charAt(0) == 'E')) {
            //조건2
            if (s.charAt(1) != 'F') { //스럼프의 경우 길이는 3이상이어야되고 두번쨰 문자는 무조건 F
                return false;
            } else {
                int cnt = 1;
                //조건 2
                while (cnt < s.length() && s.charAt(cnt) == 'F') {
                    cnt++;
                }
                if (cnt < s.length()) {
                    //조건 3
                    if (s.charAt(cnt) == 'G') {
                        if (cnt == s.length() - 1) {
                            return true;
                        }
                        return isSlump(s.substring(cnt));
                    } else {
                        if (s.charAt(cnt) == 'D' || s.charAt(cnt) == 'E') {
                            return isSlump(s.substring(cnt));
                        }
                    }
                }
            }
        }
        return false;
    }
    static boolean isSlimp(String s) {
        //조건 1
        if (s.length()>1 && s.charAt(0) == 'A') {
                //조건 2
                if(s.charAt(1) == 'H'){
                    if (!flag) {
                        flag = true;
                        idx = 2;
                    }
                return true;
                //조건 3
            }else if(s.length()>2){ //세 개 이상의 문자로 된 스림프
                int placeC = findC(s); // C의 위치를 찾음
                if(placeC==-1) return false;
                    if (!flag) {
                        flag = true;
                        idx = placeC + 1;
                    }
                //조건 3-1
                if (s.charAt(1) == 'B') {
                    if (isSlimp(s.substring(2,placeC))) {
                        return true;
                    }
                } else { //조건 3-2
                    if (isSlump(s.substring(1, placeC))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int findC(String s) {
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == 'C' && !visited[i]) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }
}