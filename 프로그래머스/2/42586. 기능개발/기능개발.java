import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        int cDays = -1;
        int done = 0;
        for(int i = 0; i < progresses.length; i++){
            int nowNeedDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if(nowNeedDays > cDays){
                answer.addLast(done);
                done = 1;
                cDays = nowNeedDays;
            }else{
                done++;
            }
        }
        answer.removeFirst();
        answer.addLast(done);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}