package org.example

import java.util.StringTokenizer


fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val tree = Array(N) { mutableListOf<Int>() }
    val st = StringTokenizer(br.readLine())
    var root = -1
    for (i in 0 until N) {
        val parent = st.nextToken().toInt()
        if (parent == -1) {
            root = i
        } else {
            tree[parent].add(i)
        }
    }
    val target = br.readLine().toInt()
//    tree.forEach{
//        println(it)
//    }
    //println("root: $root")
    if (root == target) {
        println(0)
    } else {
        println(dfs(tree, root, target))
    }

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, target: Int): Int {
    var count = 0
    var isLeaf = true
    for (neighbor in graph[v]) {
        if (neighbor != target) {
            // target이 아닌 곳만 방문해서 leaf인지 체크
            isLeaf = false
            count += dfs(graph, neighbor, target)
        }
    }
    if (isLeaf) {
        // 자식이 없어서 마지막 노드였으면
        return 1
    }
    return count
}
