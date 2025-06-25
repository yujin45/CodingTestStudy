import java.util.ArrayDeque;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int currentDays = 0;
        int done = 0;
        for(int i = 0; i < progresses.length; i++){
            int needDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if(needDays > currentDays){
                // 출하시키고 새로 넣어야 함
                deque.addLast(done);
                done = 1;
                currentDays = needDays;
            }else{
                done++;
            }
        }
        
        // 남은 것 출하
        deque.addLast(done);
        deque.removeFirst();
        return deque.stream().mapToInt(i -> i).toArray();
    }
}