import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

class Solution {
    fun solution(arr: IntArray): IntArray {
        val n = arr.size
        // 다음 2의 거듭제곱 계산
        val nextPowerOfTwo = 2.0.pow(ceil(log2(n.toDouble()))).toInt()
        val zeroCount = nextPowerOfTwo - n

        // 0 추가
        return IntArray(nextPowerOfTwo) { if (it < n) arr[it] else 0 }
    }
}
