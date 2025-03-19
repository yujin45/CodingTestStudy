import java.util.PriorityQueue

data class Task(val taskNum:Int, val requestTime:Int, val time:Int)

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        
        var totalTurnaroundTime = 0
        val requestQueue = PriorityQueue<Task>(compareBy<Task>{it.requestTime}) // 요청된 작업 순서대로 저장
        val readyQueue = PriorityQueue<Task>(compareBy<Task>{it.time}
                                            .thenBy{it.requestTime}
                                            .thenBy{it.taskNum}) // 실행 대기 큐
        
        for(i in jobs.indices){
            requestQueue.add(Task(i, jobs[i][0], jobs[i][1]))
        }
        
        var currentTime = 0
        var doneCount = 0
        
        while(doneCount<jobs.size){
            // 현재 시점에서 요청된 작업들 readyQueue에 추가
            while(requestQueue.isNotEmpty() && requestQueue.peek().requestTime <=currentTime){
                readyQueue.add(requestQueue.poll())
            }
            
            if(readyQueue.isNotEmpty()){
                // 가장 작업 시간 짧은 것 우선 실행
                val task = readyQueue.poll()
                currentTime += task.time
                totalTurnaroundTime += (currentTime - task.requestTime)
                doneCount++
            }else{
                // 비어있다면 currentTime가장 빠른 작업이 도착하는 시간
                currentTime = requestQueue.peek().requestTime
            }
        }
        
        return totalTurnaroundTime / jobs.size
    }
}