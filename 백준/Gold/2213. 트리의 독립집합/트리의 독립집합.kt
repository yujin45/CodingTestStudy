package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val weightList = IntArray(n + 1)
    for (i in 1..n) {
        weightList[i] = st.nextToken().toInt()
    }

    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val edge = StringTokenizer(br.readLine())
        val a = edge.nextToken().toInt()
        val b = edge.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = BooleanArray(n + 1)
    val dp = Array(n + 1) { IntArray(2) } // 현재선택x, 현재선택o
    val parent = IntArray(n + 1) { -1 }

    // 1. DP 계산 (DFS로 트리 DP)
//    for (i in 1..n) {
//        if (!visited[i]) {
//            dfs(graph, i, visited, weightList, dp, parent)
//        }
//    }

    // 루트가 여러개라면 위의 것으로 구하고 아래에서도 여러 루트에 대해서 진행
    dfs(graph, 1, visited, weightList, dp, parent)
    // 2. 최대 독립 집합의 크기 출력
    val maxWeight = maxOf(dp[1][0], dp[1][1])
    //println(maxWeight)
    sb.append(maxWeight).append("\n")

    // 3. 선택된 노드 추적(백트래킹)
    /*
    *trace(node, isSelected): 현재 노드가 선택되었는지 여부를 바탕으로 자식 노드 탐색
    isSelected이면 현재 노드를 선택하고, 자식 노드는 제외
    isSelected가 아니면 dp[child][1] >= dp[child][0]인 경우 자식 노드를 선택
    * */
    val selectedNodes = mutableListOf<Int>()
    val included = BooleanArray(n + 1)

    fun trace(node: Int, isSelected: Boolean) {
        if (isSelected) {
            selectedNodes.add(node) // 현재 노드가 집합에 포함되면 리스트에 추가
            included[node] = true // 방문 표시
        }
        for (neighbor in graph[node]) { // 현재 노드의 모든 자식(이웃) 노드 탐색
            if (neighbor != parent[node]) { // 부모 노드는 다시 방문하지 않도록 제외
                // isSeleted는 현재 노드가 독립 집합에 포함 여부
                // isSelected가 false여서 부모가 포함되지 않았다면 자식 노드 포함 가능
                // 부모가 독립집합에 포함되지 않았고 자식이 포함되는 것이 이득이면 자식 선택
                trace(neighbor, !isSelected && dp[neighbor][1] >= dp[neighbor][0])
            }
        }
    }
    trace(1, dp[1][1] > dp[1][0]) // 1선택한게 더 크면 현재를 selected로 두고 백트래킹 시작


    selectedNodes.sort()
    selectedNodes.forEach { sb.append(it).append(" ") }
    sb.deleteCharAt(sb.length - 1)
    println(sb)
    br.close()
}

fun dfs(
    graph: Array<MutableList<Int>>,
    v: Int,
    visited: BooleanArray,
    weightList: IntArray,
    dp: Array<IntArray>,
    parent: IntArray
) {
    visited[v] = true
    dp[v][1] = weightList[v] // 포함하는 경우
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            parent[neighbor] = v // 이웃 노드에게 v가 부모인 것 표시
            dfs(graph, neighbor, visited, weightList, dp, parent)
            dp[v][0] += maxOf(dp[neighbor][0], dp[neighbor][1]) // 나를 선택하지 않는다면 자식 중 가장 큰 값
            dp[v][1] += dp[neighbor][0] // 나를 선택하면 자식은 선택하지 않아야 함
        }
    }
}