import java.util.*;

class Task{
    int location;
    int priority;
    
    public Task(int location, int priority){
        this.location = location;
        this.priority = priority;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayDeque<Task> readyQueue = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
            readyQueue.addLast(new Task(i, priorities[i]));
        }
        
        int count = 0;
        while(!pq.isEmpty()){
            Task task = readyQueue.removeFirst();
            if(pq.peek() == task.priority){
                pq.poll();
                count++;
                if(task.location == location) return count;
            }else{
                readyQueue.addLast(task);
            }
        }
        
        return count;
    }
}