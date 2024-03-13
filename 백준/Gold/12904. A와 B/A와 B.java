import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String S,T, reverseT;
    static boolean isPossible;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        reverseT = new StringBuilder(T).reverse().toString();
        isPossible = false;
        set = new HashSet<>();
        findIsPossible(S, T);
        System.out.println(isPossible ? 1 : 0);
    }

    static void findIsPossible(String a, String b) {
        if (a.equals(b) || isPossible) {
            isPossible = true;
            return;
        }
        if(a.length()==b.length()) return;
        String next = a + "A";
        if (!set.contains(a + "A") && (T.contains(next) || reverseT.contains(next))) {
            set.add(a + "A");
            findIsPossible(a + "A", b);
        }
        StringBuilder sb = new StringBuilder(a);
        next = sb.reverse().append("B").toString();
        if (!set.contains(next) && (T.contains(next) || reverseT.contains(next))) {
            set.add(next);
            findIsPossible(next, b);
        }
    }
}