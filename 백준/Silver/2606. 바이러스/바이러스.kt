import java.util.*

fun main() {
    val n = readLine()!!.toInt() // 컴퓨터 수
    val m = readLine()!!.toInt() // 연결 정보 개수

    val graph = Array(n + 1) { mutableListOf<Int>() } // 1-based index

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    // BFS 탐색
    val visited = BooleanArray(n + 1)
    val queue: Queue<Int> = LinkedList()
    queue.add(1)
    visited[1] = true

    var infectedCount = 0

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (neighbor in graph[current]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.add(neighbor)
                infectedCount++
            }
        }
    }

    println(infectedCount)
}
