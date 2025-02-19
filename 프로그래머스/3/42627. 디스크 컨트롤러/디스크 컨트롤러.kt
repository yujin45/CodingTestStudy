import java.util.PriorityQueue

data class Task(val taskNum: Int, val requestTime: Int, val time: Int)

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var totalTurnaroundTime = 0
        val requestQueue = PriorityQueue<Task>(compareBy { it.requestTime }) // 요청된 작업을 시간 순서대로 저장
        val readyQueue = PriorityQueue<Task>(compareBy<Task> { it.time }
            .thenBy { it.requestTime }
            .thenBy { it.taskNum }) // 실행 대기 큐 (SJF 기반 우선순위)

        for (i in jobs.indices) {
            requestQueue.add(Task(i, jobs[i][0], jobs[i][1])) // 요청 시간 순으로 정렬
        }

        var currentTime = 0
        var doneCount = 0

        while (doneCount < jobs.size) {
            // 현재 시점에서 요청된 작업들을 readyQueue에 추가
            while (requestQueue.isNotEmpty() && requestQueue.peek().requestTime <= currentTime) {
                readyQueue.add(requestQueue.poll())
            }

            if (readyQueue.isNotEmpty()) {
                // 가장 작업 시간이 짧은 것부터 실행
                val task = readyQueue.poll()
                currentTime += task.time
                totalTurnaroundTime += (currentTime - task.requestTime) // 반환 시간 누적
                doneCount++ // 완료된 작업 증가
            } else {
                // readyQueue가 비어있다면 currentTime을 가장 빠른 작업이 도착하는 시간으로 Jump
                currentTime = requestQueue.peek().requestTime
            }
        }

        return totalTurnaroundTime / jobs.size // 평균 반환 시간의 정수값
    }
}
