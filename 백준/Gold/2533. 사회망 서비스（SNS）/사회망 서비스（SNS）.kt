import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()

    val graph = Array(N + 1) { ArrayList<Int>() }
    repeat(N - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val dp = Array(N + 1) { IntArray(2) }
    val parent = IntArray(N + 1) { -1 }

    dfs(1, graph, dp, parent)

    bw.write("${minOf(dp[1][0], dp[1][1])}\n")
    bw.flush()
    br.close()
    bw.close()
}

fun dfs(node: Int, graph: Array<ArrayList<Int>>, dp: Array<IntArray>, parent: IntArray) {
    dp[node][0] = 1  // 현재 노드를 얼리 아답터로 선택하는 경우
    dp[node][1] = 0  // 현재 노드를 얼리 아답터로 선택하지 않는 경우

    for (child in graph[node]) {
        if (child == parent[node]) continue  // 부모 노드 방문 방지
        parent[child] = node
        dfs(child, graph, dp, parent)

        dp[node][0] += minOf(dp[child][0], dp[child][1]) // 현재 선택 → 자식은 선택 or 비선택 가능
        dp[node][1] += dp[child][0]  // 현재 미선택 → 자식은 반드시 선택
    }
}
