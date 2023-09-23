import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int idx = 0; // 몇번째인지 확인하기 위한 변수
        // String 타입으로 작은 수에서 큰 수로 가게 정렬
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->a.length()==b.length()?Integer.parseInt(a)-Integer.parseInt(b):a.length()-b.length());
        boolean isPossible = false;
        if (n <= 10) {
            isPossible=true;
            System.out.println(n);
        }
        else {
            for (int i = 0; i < 10; i++) {
                pq.offer(String.valueOf(i));
                idx++;
            }
        }
        idx--; // 0은 0번째 감소하는 수인데 위에 for문에서 0부터 1씩 증가시켜줬으므로 1을 빼줌

        Loop1:
        for (int len = 1; len < 10; len++) { // 최대 9자릿수까지 가능
            for (int i = 1; i < 10; i++) {
                Queue<String> tmpQueue = new LinkedList<>(); //임시 큐
                while (!pq.isEmpty()) {
                    if (i > pq.peek().charAt(0) - '0') {
                        String s = pq.poll(); //현재 큐에서 가장 작은 수를 s라고 함
                        tmpQueue.offer(s);
                        idx++; //
                        if (idx == n) { // idx가 n이라면 현재 수 찍어주고 반복문 전체 종료
                            isPossible = true;
                            System.out.println(Long.parseLong(i + s));
                            break Loop1;
                        }
                        pq.offer(i + s); // pq에 새로운 수 넣기 ex) i가 4이고 s가 32라면 pq에 432를 String 타입으로 저장
                    } else {
                        break;
                    }
                }
                if (i != 9) { //i가 9가 아니라면 여태까지 pq에서 뺏던거 다시 넣음
                    while (!tmpQueue.isEmpty()) {
                        pq.offer(tmpQueue.poll());
                    }
                } else {
                    // i==9라면 pq에 현재 길이와 맞지 않는거 전부 뺌 Ex) 세자리수를 만들건데 8,9같은 한자리수가 있으면 다 뺌
                    while (!pq.isEmpty() && pq.peek().length() == len) {
                        pq.poll();
                    }
                }

            }
        }
        if (!isPossible) {
            System.out.println(-1);
        }
    }
}