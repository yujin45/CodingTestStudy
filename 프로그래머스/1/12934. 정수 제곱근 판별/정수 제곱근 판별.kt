import kotlin.math.sqrt
import kotlin.math.pow

class Solution {
    fun solution(n: Long): Long {
        // kotlin.math.sqrt() 함수는 Double 타입의 제곱근을 반환
        val x = sqrt(n.toDouble()).toLong()  
        // 제곱근을 구한 후 Long으로 변환 
        
        // x의 제곱이 n과 같은지 확인하여 정수 제곱근인지 검사
        return if (x * x == n) {
            (x + 1) * (x + 1)  // x+1의 제곱을 반환
        } else {
            -1  // 정수 제곱근이 아니면 -1 반환
        }
    }
}

class Solution2 {
    fun solution(n: Long): Long {
        val x = sqrt(n.toDouble()).toLong()  // 제곱근을 구한 후 Long으로 변환

        return if (x * x == n) {
            (x + 1).toDouble().pow(2).toLong()  // pow() 함수로 제곱
        } else {
            -1  // 정수 제곱근이 아니면 -1 반환
        }
    }
}
