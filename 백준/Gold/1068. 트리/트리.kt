import java.io.*

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val parent = br.readLine().split(" ").map { it.toInt() }
    val deleteNode = br.readLine().toInt()
    br.close()

    val graph = Array(N) { mutableListOf<Int>() }
    var root = -1

    for (i in 0 until N) {
        if (parent[i] == -1) {
            root = i
        } else {
            graph[parent[i]].add(i)
        }
    }

    // **Case 1: 삭제할 노드가 루트 노드일 경우, 전체 트리 삭제**
    if (deleteNode == root) {
        println(0)
        return
    }

    // **Case 2: DFS로 리프 노드 개수 세기**
    println(countLeafNodes(graph, root, deleteNode))
}

// DFS로 리프 노드 개수를 계산
fun countLeafNodes(graph: Array<MutableList<Int>>, node: Int, target: Int): Int {
    if (node == target) return 0  // 삭제 노드 발견 → 탐색 중지

    // 삭제 노드를 제외한 자식 노드 개수 확인
    val children = graph[node].filter { it != target }

    // **리프 노드 조건:** 자식이 없거나, 삭제된 노드만 있었던 경우
    if (children.isEmpty()) return 1

    var count = 0
    for (child in children) {
        count += countLeafNodes(graph, child, target)
    }
    return count
}
