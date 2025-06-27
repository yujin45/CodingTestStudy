import java.util.*;
class Solution {
    static class Point{
        int x, y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }
        
        @Override
        public String toString(){
            return "(" + x + ", " + y + ")";
        }
    }
    
    public int solution(int[] arrows) {
        // 행열 말고 직교 좌표계.
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        
        Set<Point> visited = new HashSet<>();
        Map<Point, Set<Point>> graph = new HashMap<>();
        
        Point current = new Point(0, 0);
        visited.add(current);
        
        int rooms = 0;
        
        for(int dir : arrows){
            for(int step = 0; step < 2; step++){ // 교차점 만들기 위해 2번 이동
                Point next = new Point(current.x + dx[dir], current.y + dy[dir]);
                
                // 양방향 간선이 없다면 새 경로
                graph.putIfAbsent(current, new HashSet<>());
                graph.putIfAbsent(next, new HashSet<>());
                
                if(visited.contains(next) && !graph.get(current).contains(next)){
                    // next 방문했지만, current와 처음 연결이라면?
                    rooms++; // 방이 새로 생김
                }
                
                // 양방향 간선 추가
                graph.get(current).add(next);
                graph.get(next).add(current);
                
                visited.add(next);
                current = next;
            }
        }
        
        return rooms;
    }
}