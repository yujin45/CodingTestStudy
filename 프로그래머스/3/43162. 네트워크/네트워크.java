import java.util.*;

class Solution {
    boolean[] visited;
    
    private void dfs(int[][] computers, int i , boolean[] visited){
        visited[i] = true;
        for(int j = 0; j < computers[i].length; j++){
            if(!visited[j] && computers[i][j] == 1){
                // 방문 전이고 연결되어 있으면
                dfs(computers, j, visited);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        visited = new boolean[n]; // n개의 컴퓨터
        int count = 0;
        for(int i = 0; i < computers.length; i++){
            if(!visited[i]){
                dfs(computers, i, visited);
                count++;
            }
        }
        return count;
    }
}