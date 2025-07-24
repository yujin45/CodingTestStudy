import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int currentDays = 0;
        int done = 0;
        
        for(int i = 0; i < progresses.length; i++){
            int needDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if(needDays > currentDays){
                deque.addLast(done);
                done = 0;
                currentDays = needDays;
            }
            done++;
        }
        
        deque.addLast(done);
        deque.removeFirst();
        return deque.stream().mapToInt(i->i).toArray();
        
    }
}