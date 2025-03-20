import java.util.PriorityQueue

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val graph = HashMap<String, PriorityQueue<String>>()

        // 우선순위 큐를 사용해 알파벳 순으로 탐색 (사전순 정렬)
        for ((from, to) in tickets) {
            graph.computeIfAbsent(from) { PriorityQueue() }.add(to)
        }

        val route = mutableListOf<String>()

        fun dfs(airport: String) {
            val destinations = graph[airport]

            while (destinations != null && destinations.isNotEmpty()) {
                val next = destinations.poll()
                dfs(next)
            }

            // 역순으로 삽입하여 최종 경로를 구성
            route.add(airport)
        }

        dfs("ICN")

        return route.reversed().toTypedArray()
    }
}
