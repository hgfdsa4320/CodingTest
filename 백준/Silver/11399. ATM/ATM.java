import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int time(int[] a,int N){
        int t=0;
        for(int i=0;i<N;i++)
            t=t+(N-i)*a[i];
        return t;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] p=new int[N];
        for(int i=0;i<N;i++)
            p[i]=sc.nextInt();
        Arrays.sort(p);
        int k=time(p,N);
        System.out.println(k);
    }
}