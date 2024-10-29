import java.util.*;

class Solution {
    static List<Integer>[] idList;
    static boolean[] visited;
    static Set<Set<Integer>> uniqueCombinations;
    static int bannedCount;
    
    // 패턴이 일치하는지 확인하는 메서드
    static boolean isMatch(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;
        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // 불량 사용자 ID와 일치하는 유저 ID를 idList에 저장
    static void findMatchingIds(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (isMatch(user_id[j], banned_id[i])) {
                    idList[i].add(j);
                }
            }
        }
    }
    
    // DFS를 통한 가능한 조합 찾기
    static void dfs(int depth, Set<Integer> currentCombination) {
        if (depth == bannedCount) {
            uniqueCombinations.add(new HashSet<>(currentCombination));
            return;
        }
        
        for (int userIdIndex : idList[depth]) {
            if (!visited[userIdIndex]) {
                visited[userIdIndex] = true;
                currentCombination.add(userIdIndex);
                dfs(depth + 1, currentCombination);
                currentCombination.remove(userIdIndex);
                visited[userIdIndex] = false;
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        bannedCount = banned_id.length;
        idList = new ArrayList[bannedCount];
        visited = new boolean[user_id.length];
        uniqueCombinations = new HashSet<>();
        
        for (int i = 0; i < bannedCount; i++) {
            idList[i] = new ArrayList<>();
        }
        
        // 각 불량 사용자 ID에 맞는 사용자 ID 목록 생성
        findMatchingIds(user_id, banned_id);
        
        // DFS를 사용하여 가능한 모든 조합 탐색
        dfs(0, new HashSet<>());
        
        return uniqueCombinations.size();
    }
}
