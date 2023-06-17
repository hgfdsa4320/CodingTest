import java.util.*;

class Solution {
    static List<int[]> list; // 후보키 후보를 담을 리스트
    static List<int[]> res; // 후보키를 담을 리스트
    static boolean[] visited;
    static int index; // dfs에서 중복 제외하기 위한 인덱스
    static int n; // 칼럼 수
    public int solution(String[][] relation) {
        res = new ArrayList<>();
        n = relation[0].length;
        for(int i=1;i<=n;i++){
            list = new ArrayList<>();
            visited = new boolean[n];
            index = 0;
            dfs(i,0); // 칼럼수가 i개인 후보키 후보를 리스트에 저장
        
            Loop1:
            for(int[] tmp : list){
                //유일성 검증을 위한 Set ex)이름+전공일 경우 -> ryan music으로 저장
                Set<String> set = new HashSet<>(); 
                for(int j=0;j<res.size();j++){
                    if(contains(tmp,res.get(j))) //최소성이 아니면 continue
                        continue Loop1;
                }
                for(int j=0;j<relation.length;j++){
                    StringBuilder sb = new StringBuilder(); 
                    for(int k=0;k<tmp.length;k++){
                        sb.append(relation[j][tmp[k]]).append(" ");
                    }
                    if(set.contains(sb.toString())){ //유일성이 아니면 continue
                        continue Loop1;
                    }
                    set.add(sb.toString());
                }
                res.add(tmp);
            }            
        }
        return res.size();
    }
    static void dfs(int v,int cnt){
        if(cnt==v){
            int[] tmp = new int[v];
            int idx = 0;
            for(int i=0;i<n;i++){
                if(visited[i]){
                    tmp[idx++] = i;
                }
            }
            list.add(tmp);
        }
        for(int i=index;i<n;i++){
            if(!visited[i]){
                visited[i]= true;
                dfs(v,cnt+1);
                visited[i]=false;
                index = i+1;
            }
        }
    }
    static boolean contains(int[] a, int[] b){ //a가 b를 포함하고 있는지 판단하는 함수
        for(int i=0;i<b.length;i++){
            boolean isOkay = false;
            for(int j=0;j<a.length;j++){
                if(a[j]==b[i]){
                    isOkay=true;
                    break;
                }
            }
            if(!isOkay) return false;
        }
        return true;
    }
}