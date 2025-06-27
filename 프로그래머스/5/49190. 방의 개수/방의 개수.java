import java.util.*;

class Solution {
    
    static class Point{
        int x, y;
        
        public Point(int x, int y){
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
    }
    
    
    public int solution(int[] arrows) {
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        
        Set<Point> visited = new HashSet<>();
        Map<Point, Set<Point>> graph = new HashMap<>();
        
        Point current = new Point(0, 0);
        visited.add(current);
        
        int rooms = 0;
        for(int dir : arrows){
            for(int step = 0; step < 2; step++){ // 선 겹침 위해서 2회 진행
                Point next = new Point(current.x + dx[dir], current.y + dy[dir]);
                
                graph.putIfAbsent(current, new HashSet<>()); // 없으면 생성
                graph.putIfAbsent(next, new HashSet<>());
                
                if(visited.contains(next) && !graph.get(current).contains(next)){
                    rooms++;
                }
                
                graph.get(current).add(next);
                graph.get(next).add(current);
                
                visited.add(next);
                current = next;
            }
        }
        
        return rooms;
    }
}