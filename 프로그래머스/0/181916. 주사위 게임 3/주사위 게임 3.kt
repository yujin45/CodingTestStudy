class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        val counts = listOf(a, b, c, d).groupingBy { it }.eachCount() // 숫자 빈도 계산

        return when (counts.size) {
            1 -> { // 네 숫자가 모두 같음
                1111 * a
            }
            2 -> {
                val (p, q) = counts.keys.toList()
                val (countP, countQ) = counts.values.toList()

                when {
                    countP == 3 || countQ == 3 -> { // 세 개가 같고 하나는 다름
                        val main = if (countP == 3) p else q
                        val sub = if (countP == 1) p else q
                        (10 * main + sub).let { it * it }
                    }
                    else -> { // 두 개씩 같은 경우
                        (p + q) * kotlin.math.abs(p - q)
                    }
                }
            }
            3 -> { // 두 개가 같고 나머지는 각각 다름
                val (pairNum, _) = counts.filter { it.value == 2 }.entries.first()
                val others = counts.filter { it.value == 1 }.keys.toList()
                others[0] * others[1]
            }
            4 -> { // 네 숫자가 모두 다름
                counts.keys.minOrNull() ?: 0
            }
            else -> 0 // 예외 처리 (실제 조건에는 없음)
        }
    }
}
