import java.util.*;


class Node{
    
    int cnt;
    String word;
    
    public Node(int cnt, String word){
        this.cnt = cnt;
        this.word = word;
    }
}

class Solution {
    static int answer;
    static boolean[] visited;
    static List<String> list;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        list = new ArrayList<>();
        for(String word : words){
            list.add(word);
        }
        if(!list.contains(target)) return answer;
        bfs(0,begin,target,words);
        return answer;
    }
    
    static void bfs(int cnt, String word, String target, String[] words){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(cnt,word));
        if(list.contains(word)){
            visited[list.indexOf(word)]=true;    
        }
        
        
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.word.equals(target)){
                answer = node.cnt;
                break;
            }else{
                for(int i=0;i<words.length;i++){
                    if(!visited[i] && canTrans(node.word,words[i])){
                        visited[i]=true;
                        q.offer(new Node(node.cnt+1,words[i]));
                    }
                }
            }
        }
    }
    
    static boolean canTrans(String s1, String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
        }
        if(count==1){
            return true;
        }
        return false;
    }
}