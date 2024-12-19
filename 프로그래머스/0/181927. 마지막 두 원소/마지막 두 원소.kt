class Solution1 {
    fun solution(num_list: IntArray): IntArray {
        val last = num_list.last() // 마지막 원소
        val secondLast = num_list[num_list.lastIndex - 1] // 마지막에서 두 번째 원소

        // 새로운 원소 계산
        val newElement = if (last > secondLast) last - secondLast else last * 2

        // 기존 배열에 새로운 원소를 추가한 새로운 배열 반환
        return num_list + newElement
    }
}


class Solution {
    fun solution(num_list: IntArray): IntArray {
        val answer = num_list.toMutableList().apply {
            val (first, second) = num_list.takeLast(2)
            if (first < second) add(second - first)
            else add(second + second)
        }
        return answer.toIntArray()    
    }
}