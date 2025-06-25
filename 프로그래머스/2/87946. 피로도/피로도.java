class Solution {
    int maxValue = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        backtrack(0, k, dungeons);
        return maxValue;
    }
    
    private void backtrack(int depth, int current, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            // current가 다음 진행 가능한지 봐야 함
            if(current >= dungeons[i][0]){
                if(!visited[i]){
                    visited[i] = true;
                    backtrack(depth+1, current - dungeons[i][1], dungeons);
                    visited[i] = false;
                 }
            }else{
                // 더 이상 진행 불가라면 탐색 그만
                maxValue = Math.max(maxValue, depth);
            }
            
        }
    }
}