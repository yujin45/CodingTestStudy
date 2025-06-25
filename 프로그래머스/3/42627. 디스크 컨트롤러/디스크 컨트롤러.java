import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Task{
    int id;
    int reqTime;
    int time;
    
    public Task(int id, int reqTime, int time){
        this.id = id;
        this.reqTime = reqTime;
        this.time = time;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        List<Task> jobList = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++){
            jobList.add(new Task(i, jobs[i][0], jobs[i][1]));
        }
        jobList.sort(Comparator.comparingInt((Task t)-> t.reqTime));
        
        PriorityQueue<Task> readyQueue = new PriorityQueue<>(Comparator
                                                             .comparingInt((Task t)->t.time)
                                                             .thenComparingInt((Task t)->t.reqTime)
                                                             .thenComparingInt((Task t)->t.id));
        int currentTime = 0;
        int totalTime = 0;
        int index = 0;
        int count = 0;
        
        // 모든 job 끝낼 때까지 진행
        while(count < jobs.length){
            // 현재 시간까지 도달한 작업들 readyQueue에 추가
            while(index < jobList.size() && jobList.get(index).reqTime <= currentTime){
                readyQueue.add(jobList.get(index));
                index++;
            }
            
            // 실행 가능한 작업 있다면 실행
            if(!readyQueue.isEmpty()){
                Task task = readyQueue.poll();
                currentTime += task.time;
                totalTime += (currentTime - task.reqTime);
                count++;
            }else{
                // 실행할 수 있는 작업이 없다면 시간만 증가
                currentTime++;
            }
        }
        
        return totalTime/jobs.length;
    }
}