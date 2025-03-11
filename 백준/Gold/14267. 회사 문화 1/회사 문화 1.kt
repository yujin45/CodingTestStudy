package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val numOfUpPeople = StringTokenizer(br.readLine())
    val graph = Array(n + 1) { mutableListOf<Int>() }
    var root = 0
    for (i in 1..n) {
        // 1번부터 n번까지 사원의 직장 상사 받아오기
        val up = numOfUpPeople.nextToken().toInt()
        if (up != -1) {
            graph[up].add(i) // 상사에 나를 연결 상사 -> 직원 단방향
        } else {
            root = i // -1인거면 i가 사장임.
        }
    }

    // 칭찬 받은 것을 저장해두기
    val wList = IntArray(n + 1)
    repeat(m) {
        val st = StringTokenizer(br.readLine())
        wList[st.nextToken().toInt()] += st.nextToken().toInt()
    }
    //println(wList.contentToString())
    dfs(graph, root, wList)

    val sb = StringBuilder()
    for (i in 1..n) {
        sb.append(wList[i]).append(" ")
    }
    sb.deleteCharAt(sb.length - 1)
    println(sb)

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, num: Int, wList: IntArray) {
    //println("num: $num - - wList: ${wList.contentToString()}")
    for (neighbor in graph[num]) {
        wList[neighbor] += wList[num] // 부모의 칭찬을 자식에게 누적 전달 ★
        dfs(graph, neighbor, wList)
    }
}
