import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val T = br.readLine().toInt()

    repeat(T) {
        val n = br.readLine().toInt()
        val graph = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val visited = BooleanArray(n + 1)
        val finished = BooleanArray(n + 1) // 탐색 종료 여부 체크
        var count = 0 // 사이클에 포함된 학생 수

        fun dfs(v: Int) {
            visited[v] = true
            val next = graph[v - 1]

            if (!visited[next]) {
                dfs(next)
            } else if (!finished[next]) {
                // 사이클이 발생한 경우
                var node = next
                while (node != v) {
                    count++
                    node = graph[node - 1]
                }
                count++ // 자기 자신도 카운트
            }
            finished[v] = true // 탐색 완료 처리
        }

        for (i in 1..n) {
            if (!visited[i]) dfs(i)
        }

        sb.append(n - count).append("\n") // 전체 학생 - 팀에 속한 학생 수
    }

    print(sb)
}
