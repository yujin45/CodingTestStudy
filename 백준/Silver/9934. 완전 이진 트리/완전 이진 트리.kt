package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val K = br.readLine().toInt()

    val treeList = br.readLine().split(" ").map { it.toInt() }
    br.close()

    val levels = Array(K) { ArrayList<Int>() } // 깊이 별 노드 저장 리스트
    buildTree(treeList, levels, 0, 0, treeList.size - 1)

    val sb = StringBuilder()
    for (level in levels) {
        sb.append(level.joinToString(" ")).append("\n")
    }
    print(sb)
}

// 리스트 복사 대신 인덱스 범위 사용
fun buildTree(treeList: List<Int>, levels: Array<ArrayList<Int>>, depth: Int, start: Int, end: Int) {
    if (start > end) return

    val mid = (start + end) / 2
    levels[depth].add(treeList[mid]) // 해당 depth 에 추가

    buildTree(treeList, levels, depth + 1, start, mid - 1) // 왼쪽 서브트리
    buildTree(treeList, levels, depth + 1, mid + 1, end) // 오른쪽 서브트리
}
