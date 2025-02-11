package org.example

fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val graph = Array(N + 1) { mutableListOf<Int>() }
    for (i in 1..N) {
        graph[i].add(br.readLine().toInt()) // 방향 그래프
    }
    val sb = StringBuilder()
    val ret = mutableListOf<Int>() // 뽑힌 정수들 넣어줄 용도, 이후 오름차순 정렬
    for (i in 1..N) {
        val visited = BooleanArray(N + 1)
        if (!visited[i]) {
            // 방문 전이면 dfs 수행해서 사이클 있는지 알아내기
            val cycle = mutableListOf<Int>()
            visited[i] = true // 시작 설정
            if (dfs(graph, i, visited, cycle, i)) {
                // 사이클 발생한 것
                ret += cycle
            }
        }
    }


    val retSortedDistinct = ret.distinct().sorted()
    sb.append(retSortedDistinct.size).append("\n")
    retSortedDistinct.forEach { sb.append(it).append("\n") }
    print(sb)

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray, cycle: MutableList<Int>, root: Int): Boolean {

    cycle.add(v)
    //println("v : $v / visited: $visited / cycle : $cycle")
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            // 방문 전이라면
            visited[neighbor] = true
            if (dfs(graph, neighbor, visited, cycle, root)) {
                return true
            }
        } else if (neighbor == root) {
            // 방문했던건데 root로 되돌아오면 사이클 발생
            return true
        }
    }

    return false
}
