package org.example


fun main() {
    val br = System.`in`.bufferedReader()

    // 카드 합이 21을 넘지 않는 한도 내에서 카드의 합을 최대한 크게 만드는 게임
    // n개의 카드 중 3장 고르기
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val cards = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(N) //N개의 카드 방문 여부
    val sequence = IntArray(3) // 3개 들어갈 것
    var totalMax = Int.MIN_VALUE
    fun backtrack(depth: Int) {
        if (depth == 3) {
            // 3개 뽑으면 확인하기
            val total = sequence[0] + sequence[1] + sequence[2]
            if (total <= M) {
                totalMax = maxOf(totalMax, total)
            }
            return
        }

        for (i in cards.indices) {
            if (!visited[i]) {
                visited[i] = true
                sequence[depth] = cards[i]
                backtrack(depth + 1)
                visited[i] = false
            }

        }
    }

    backtrack(0)
    println(totalMax)
    br.close()
}
