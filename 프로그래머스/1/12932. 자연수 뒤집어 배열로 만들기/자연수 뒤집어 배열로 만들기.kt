class Solution {
    fun solution(n: Long): IntArray {
        return n.toString()
            .map { it.toString().toInt() }  // n을 문자열로 변환한 후, 각 문자를 Int로 변환하여 리스트로 만듦
            .reversed()                      // 리스트를 역순으로 뒤집음
            .toIntArray()                    // 리스트를 IntArray로 변환하여 반환
    }
}

class Solution1 {
    fun solution(n: Long): IntArray {
        return n.toString()
            .reversed()                  // 문자열을 뒤집음
            .map { it.toString().toInt() } // 각 문자를 Int로 변환
            .toIntArray()                 // List를 IntArray로 변환
    }
}
