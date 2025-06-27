class Solution {
    int maxValue = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        backtrack(0, k, dungeons);
        
        return maxValue;
    }
    
    private void backtrack(int depth, int current, int[][] dungeons){
        if(depth <= dungeons.length){
            maxValue = Math.max(maxValue, depth);
        }
        if(depth >= dungeons.length) return;
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && current >= dungeons[i][0]){
                visited[i] = true;
                backtrack(depth+1, current - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
    
}

// class Solution {
//     int maxValue = 0;
//     boolean[] visited;
    
//     public int solution(int k, int[][] dungeons) {
//         visited = new boolean[dungeons.length];
        
//         backtrack(0, k, dungeons);
//         return maxValue;
//     }
    
//     private void backtrack(int depth, int current, int[][] dungeons){
//         maxValue = Math.max(maxValue, depth);
//         for(int i = 0; i < dungeons.length; i++){
//             // current가 다음 진행 가능한지 봐야 함
//             if(current >= dungeons[i][0]){
//                 if(!visited[i]){
//                     visited[i] = true;
//                     backtrack(depth+1, current - dungeons[i][1], dungeons);
//                     visited[i] = false;
//                  }
//             }
//         }
//     }
// }