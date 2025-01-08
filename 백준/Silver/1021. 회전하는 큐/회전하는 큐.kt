package org.example

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val checklist = br.readLine().split(" ").map { it.toInt() }

    var total = 0

    val queue = ArrayDeque<Int>()
    (1..n).map { queue.add(it) }

    for (c in checklist) {
        val targetIndex = queue.indexOf(c)
        val leftmoves = targetIndex
        val rightmoves = queue.size - targetIndex

        total += minOf(leftmoves, rightmoves)

        if (leftmoves <= rightmoves) {
            queue.rotateLeft(leftmoves)
        } else {
            queue.rotateRight(rightmoves)
        }
        queue.removeFirst()
    }
    println(total)
}

fun <T> ArrayDeque<T>.rotateLeft(steps: Int) {
    repeat(steps % this.size) {
        this.addLast(this.removeFirst())
    }
}

fun <T> ArrayDeque<T>.rotateRight(steps: Int) {
    repeat(steps % this.size) {
        this.addFirst(this.removeLast())
    }
}