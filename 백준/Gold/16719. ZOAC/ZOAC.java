import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean[] visited = new boolean[s.length()];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = 'Z' + 1;
            int idx = -1;
            for (int j = s.length() - 1; j >= 0; j--) {
                if (visited[j] && idx != -1) {
                    break;
                } else if(!visited[j]) {
                    if (s.charAt(j) <= c) {
                        c = s.charAt(j);
                        idx = j;
                    }
                }
            }
            visited[idx] = true;
            StringBuilder now = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (visited[j]) now.append(s.charAt(j));
            }
            res.append(now).append("\n");
        }
        System.out.println(res);
    }
}