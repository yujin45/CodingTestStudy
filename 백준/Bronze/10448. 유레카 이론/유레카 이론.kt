package org.example


fun main() {
    val br = System.`in`.bufferedReader()

    val trinum = IntArray(44)
    for (i in 1..44) {
        trinum[i - 1] = i * (i + 1) / 2
    }

    val sequence = IntArray(3)
    fun backtrack(depth: Int, target: Int): Boolean {
        if (depth == 3) {
            // 3개의 삼각수 합
            //println(sequence.contentToString())
            if (sequence.sum() == target) {
                return true
            } else {
                return false
            }
        }

        for (i in trinum.indices) {
            sequence[depth] = trinum[i]
            if (backtrack(depth + 1, target)) return true
        }
        return false
    }

    val sb = StringBuilder()
    val T = br.readLine().toInt()
    repeat(T) {
        val K = br.readLine().toInt()
        if (backtrack(0, K)) {
            sb.append("1\n")
        } else {
            sb.append("0\n")
        }
    }
    print(sb)
    br.close()
}
