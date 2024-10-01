class Solution1 {
    fun solution(n: Long): Long {
        return n.toString()
            .map { it.toString().toInt() }   // 각 문자를 숫자로 변환
            .sortedDescending()              // 내림차순 정렬
            .joinToString("")                // 문자열로 합침
            .toLong()                        // Long 타입으로 변환하여 반환
    }
}

class Solution {
    fun solution(n: Long): Long {
        return String(n.toString().toCharArray().sortedArrayDescending())
            .toLong()                    
    }
}
