import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> readyQueue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++){
            readyQueue.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        int count = 0;
        while(!readyQueue.isEmpty()){
            int[] current = readyQueue.poll();
            if(current[1] == pq.peek()){
                // 가장 큰 우선순위
                pq.poll();
                count++;
                if(current[0] == location){
                    return count;
                }
            }else{
                readyQueue.add(current);
            }
        }
        return count;
    }
}