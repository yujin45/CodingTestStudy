import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] node : edge){
            int a = node[0];
            int b = node[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n+1];
        
        queue.offer(1); // 1번 노드부터 시작 & depth = 0
        distance[1] = 1;
        while(!queue.isEmpty()){
            int cNode = queue.poll();
           
            for(int next : graph.get(cNode)){
                if(distance[next] == 0){
                    distance[next] = distance[cNode] + 1;
                    queue.offer(next);
                }
            }
        }
 
        int maxDist = Arrays.stream(distance).max().getAsInt();
        
        int answer = 0;
        for(int dist : distance){
            if(dist == maxDist) answer++;
        }
        return answer;
    }
}