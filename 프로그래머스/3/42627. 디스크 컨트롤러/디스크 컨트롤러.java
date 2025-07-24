import java.util.*;

class Task{
    int id, reqTime, duration;
    
    public Task(int id, int reqTime, int duration){
        this.id = id;
        this.reqTime= reqTime;
        this.duration = duration;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        // job을 요청사항 우선으로 정렬
        List<Task> jobList = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++){
            jobList.add(new Task(i, jobs[i][0], jobs[i][1]));
        }
        
        jobList.sort(Comparator.comparingInt((Task t) -> t.reqTime));
        
        ArrayDeque<Task> jobQueue = new ArrayDeque<>(jobList);
        PriorityQueue<Task> readyQueue = new PriorityQueue<>(Comparator.comparingInt((Task t) -> t.duration)
                                                            .thenComparingInt(t -> t.reqTime)
                                                            .thenComparingInt(t -> t.id));
        
        int done = 0;
        int totalTime= 0;
        int current = 0;
        while(done < jobs.length){
            // current 전에 해당하는 요청사항 readyQueue에 넣기
            while(!jobQueue.isEmpty() && jobQueue.peekFirst().reqTime <= current){
                readyQueue.offer(jobQueue.removeFirst());
            }
            
            // readyQueue에 뭐 있으면 진행 없으면 요청사항 다음 것으로 current 이동
            if(!readyQueue.isEmpty()){
                Task task = readyQueue.poll();
                current += task.duration;
                totalTime += (current - task.reqTime);
                done++;
            }else{
                if(!jobQueue.isEmpty()) current = jobQueue.peekFirst().reqTime;
            }
        }
        
        return totalTime/jobs.length;
    }
}