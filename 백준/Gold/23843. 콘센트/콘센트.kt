import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val needTime = br.readLine().split(" ").map { it.toInt() }

    val pq = PriorityQueue<Int>() // 최소 힙 (가장 적게 걸린 충전 시간이 우선)
    
    // m개의 콘센트 초기 세팅
    repeat(m) { pq.add(0) } 

    for (time in needTime.sortedDescending()) { 
        val minTime = pq.poll() // 가장 빨리 끝나는 콘센트 가져오기
        pq.add(minTime + time)  // 새로운 기기 충전 후 다시 큐에 추가
    }

    println(pq.maxOrNull()) // 가장 오래 걸리는 충전 시간 출력
}
