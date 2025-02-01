fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }
    val operatorCounts = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    var maxResult = Int.MIN_VALUE
    var minResult = Int.MAX_VALUE

    // DFS 탐색: index는 현재 numbers의 인덱스, current는 지금까지 계산 결과
    fun dfs(index: Int, current: Int) {
        if (index == n) {
            maxResult = maxOf(maxResult, current)
            minResult = minOf(minResult, current)
            return
        }

        for (i in 0 until 4) {
            if (operatorCounts[i] > 0) { // 연산자 남아 있을 때만 사용
                operatorCounts[i]-- // 연산자 개수 줄이기
                val nextNumber = numbers[index]
                val newResult = when (i) {
                    0 -> current + nextNumber
                    1 -> current - nextNumber
                    2 -> current * nextNumber
                    3 -> {
                        if (current < 0) -(-current / nextNumber) else current / nextNumber
                    }
                    else -> current
                }
                dfs(index + 1, newResult)
                operatorCounts[i]++ // 연산자 개수 복구 (백트래킹)
            }
        }
    }

    dfs(1, numbers[0])

    println(maxResult)
    println(minResult)
    br.close()
}
