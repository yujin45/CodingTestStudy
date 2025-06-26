import java.util.*;

class Solution {
    // 우, 하, 좌, 상
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        // 0벽 1지나갈 수 있음
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        queue.addLast(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.removeFirst();
            if(current[0] == n-1 && current[1] == m-1){
                break;
            }
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];
                if(0<= nx && nx < maps.length && 0<=ny && ny < maps[0].length){
                    if(!visited[nx][ny] && maps[nx][ny] != 0){
                        maps[nx][ny] += maps[current[0]][current[1]];
                        queue.addLast(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            
        }
        
        int answer = -1;
        if(maps[n-1][m-1] > 1){
            answer = maps[n-1][m-1];
        }
        return answer;
    }
}