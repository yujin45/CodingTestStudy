package org.example

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(r) { br.readLine().toCharArray() }

    var totalSheep = 0
    var totalWolf = 0

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == 'v' || graph[i][j] == 'o') {
                val (sheep, wolf) = dfs(graph, i, j)
                if (sheep > wolf) {
                    totalSheep += sheep
                } else {
                    totalWolf += wolf
                }
            }

        }
    }
    println("$totalSheep $totalWolf")
    br.close()
}

fun dfs(graph: Array<CharArray>, x: Int, y: Int): Pair<Int, Int> {
    if (x !in graph.indices || y !in graph[0].indices || graph[x][y] == '#') {
        return Pair(0, 0)
    }

    var sheep = 0
    var wolf = 0

    if (graph[x][y] == 'v') wolf++
    else if (graph[x][y] == 'o') sheep++

    graph[x][y] = '#'

    for (i in 0..3) {
        val (ns, nw) = dfs(graph, x + dx[i], y + dy[i])
        sheep += ns
        wolf += nw
    }
    return Pair(sheep, wolf)
}