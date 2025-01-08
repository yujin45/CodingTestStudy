import java.util.ArrayDeque
import java.util.LinkedList

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val targets = readLine()!!.split(" ").map { it.toInt() }

    val queue = ArrayDeque((1..n).toList())

    var totalOperations = 0

    for (target in targets) {
        val targetIndex = queue.indexOf(target)

        // 왼쪽과 오른쪽 이동 거리 계산
        val leftMoves = targetIndex
        val rightMoves = queue.size - targetIndex

        // 최소 이동 거리 선택 및 큐 이동
        if (leftMoves <= rightMoves) {
            repeat(leftMoves) { queue.addLast(queue.removeFirst()) } // 왼쪽으로 이동
            totalOperations += leftMoves
        } else {
            repeat(rightMoves) { queue.addFirst(queue.removeLast()) } // 오른쪽으로 이동
            totalOperations += rightMoves
        }

        // 첫 번째 원소 제거
        queue.removeFirst()
    }

    println(totalOperations)
}
