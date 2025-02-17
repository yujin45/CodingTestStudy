package org.example

data class Node(
    val num: Int,
    var depth: Int,
)

fun main() {
    val br = System.`in`.bufferedReader()
    val K = br.readLine().toInt()

    val treeList = br.readLine().split(" ").map { it.toInt() }
    val tree = mutableListOf<Node>()
    val sb = StringBuilder()
    search(treeList, tree, 0)
    tree.sortWith(compareBy<Node> { it.depth })
    //println(tree)
    var depth = 0

    for (node in tree) {
        if (node.depth > depth) {
            sb.deleteCharAt(sb.length - 1)
            sb.append("\n")
            depth = node.depth
        }
        sb.append(node.num).append(" ")
    }
    sb.deleteCharAt(sb.length - 1).append("\n")
    print(sb)
    br.close()
}

fun search(treeList: List<Int>, tree: MutableList<Node>, depth: Int) {
    if (treeList.size == 1) {
        //1개 남은거면 그냥 넣고 리턴
        tree.add(Node(treeList[0], depth))
        return
    }
    val mid = treeList.size / 2
    tree.add(Node(treeList[mid], depth))
    search(treeList.subList(0, mid), tree, depth + 1)
    search(treeList.subList(mid + 1, treeList.size), tree, depth + 1)
}
