package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    // 노드별 가중치 저장
    val weightMap = hashMapOf<Int, Int>()
    for (i in 1..n) {
        weightMap[i] = st.nextToken().toInt()
    }
    //println(weightMap)

    // DP 테이블 및 그래프 초기화
    val dp = Array(n + 1) { IntArray(2) { 0 } }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = BooleanArray(n + 1)
    val parent = IntArray(n + 1) { -1 } // 부모 정보 저장

    // dfs 기반 dp 수행하기
    dfs(graph, 1, visited, dp, weightMap, parent)
    //println(dp.contentDeepToString())

    // 최대 독립 집합 크기 출력
    val maxWeight = maxOf(dp[1][0], dp[1][1])
    println(maxWeight)

    // 백트래킹을 이용해 실제 독립 집합 찾기
    val result = mutableListOf<Int>()
    trace(graph, 1, dp, parent, select = (dp[1][0] > dp[1][1]), result)

    // 정렬 후 출력
    val sb = StringBuilder()
    result.sorted().forEach { sb.append(it).append(" ") }
    sb.deleteCharAt(sb.length - 1)
    //println(result.sorted().joinToString(" "))
    println(sb)
    br.close()
}

// DFS 기반 DP 계산
fun dfs(
    graph: Array<MutableList<Int>>,
    v: Int,
    visited: BooleanArray,
    dp: Array<IntArray>,
    weightMap: HashMap<Int, Int>,
    parent: IntArray
) {
    visited[v] = true
    dp[v][0] = weightMap.getValue(v) // 현재 노드를 선택한 경우
    dp[v][1] = 0 // 현재 노드를 선택하지 않은 경우

    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            parent[neighbor] = v // 부모 정보 저장
            dfs(graph, neighbor, visited, dp, weightMap, parent)

            // 현재 노드를 선택한 경우(자식 노드는 선택할 수 없음)
            dp[v][0] += dp[neighbor][1]
            // 현재 노드를 선택하지 않는 경우 (자식은 선택할 수도 있음 - 가장 큰거로 정하기)
            dp[v][1] += maxOf(dp[neighbor][0], dp[neighbor][1])
        }
    }
}

// 백트래킹을 이용해 최대 독립 집합 찾기
fun trace(
    graph: Array<MutableList<Int>>,
    v: Int,
    dp: Array<IntArray>,
    parent: IntArray,
    select: Boolean,
    result: MutableList<Int>,
) {
    if (select) {
        result.add(v) // 현재 노드를 포함
    }

    for (neighbor in graph[v]) {
        if (parent[neighbor] == v) { // 부모 - 자식 관계 유지하는 노드만 처리
            if (select) {
                // 부모가 선택되었다면, 자식은 선택할 수 없음
                trace(graph, neighbor, dp, parent, select = false, result)
            } else {
                // 부모가 선택되지 않았다면, 자식은 선택될 수도 있음
                trace(graph, neighbor, dp, parent, select = (dp[neighbor][0] > dp[neighbor][1]), result)
            }
        }
    }
}