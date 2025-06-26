import java.util.*;

class Solution {
    boolean[] visited;
    List<String> answer = new ArrayList<>();
    List<String> path = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        // 티켓들을 사전순으로 정렬
        Arrays.sort(tickets, (a, b) ->{
            if(!a[0].equals(b[0])){
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);
        });
        
        path.add("ICN");
        dfs("ICN", tickets, 0);
        
        return answer.toArray(new String[0]);
        //return answer.stream().toArray(String[]::new)
    }
    
    private boolean dfs(String current, String[][] tickets, int usedCount){
        if(usedCount == tickets.length){
            answer = new ArrayList<>(path); // 정답 저장
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                path.add(tickets[i][1]);
                
                if(dfs(tickets[i][1], tickets, usedCount+1)){
                    return true; // true 반환되면 찾은 것
                }
                visited[i] = false;
                path.remove(path.size() -1); // 마지막에 넣었던 것 제거 해주기
            }
        }
        return false; 
    }
}