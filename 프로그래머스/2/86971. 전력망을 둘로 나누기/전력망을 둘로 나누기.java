import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>()); // 0은 제외 n까지 노드
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] subTree = new int[n+1];
        dfs(graph, visited, 1, subTree);
       
        for(int i = 0; i < subTree.length; i++){
            subTree[i] = Math.abs(subTree[i] - (n - subTree[i]));
        }
        
        for(int i = 2; i < subTree.length; i++){
            minDiff = Math.min(minDiff, subTree[i]);
        }
        return minDiff;
    }
    
    private void dfs(List<List<Integer>> graph, boolean[] visited, int node, int[] subTree){
        visited[node] = true;
        subTree[node] = 1; // 자기 자신
        
        for(int next : graph.get(node)){
            if(!visited[next]){
                dfs(graph, visited, next, subTree);
                subTree[node] += subTree[next];
            }
        }
        
    }
}