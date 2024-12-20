class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        val (a, b, c) = slicer
        return when (n) {
            1 -> IntArray(b + 1) { num_list[it] }        // 0부터 b까지
            2 -> IntArray(num_list.size - a) { num_list[a + it] } // a부터 끝까지
            3 -> IntArray(b - a + 1) { num_list[a + it] } // a부터 b까지
            4 -> IntArray((b - a) / c + 1) { num_list[a + it * c] } // a부터 b까지 c 간격으로
            else -> intArrayOf()                         // 빈 배열 반환
        }
    }
}

/*
테스트 1 〉	통과 (0.01ms, 63.1MB)
테스트 2 〉	통과 (0.01ms, 63.4MB)
테스트 3 〉	통과 (0.01ms, 63.2MB)
테스트 4 〉	통과 (0.02ms, 64MB)
테스트 5 〉	통과 (0.01ms, 62.7MB)
테스트 6 〉	통과 (0.02ms, 63.5MB)
테스트 7 〉	통과 (0.01ms, 63.5MB)
테스트 8 〉	통과 (0.01ms, 63.9MB)
테스트 9 〉	통과 (0.01ms, 63.8MB)
테스트 10 〉	통과 (0.01ms, 60.9MB)
테스트 11 〉	통과 (0.02ms, 63MB)
테스트 12 〉	통과 (0.01ms, 63.1MB)
테스트 13 〉	통과 (0.02ms, 62.8MB)
테스트 14 〉	통과 (0.01ms, 62.9MB)
테스트 15 〉	통과 (0.01ms, 63.8MB)
테스트 16 〉	통과 (0.02ms, 64.4MB)
테스트 17 〉	통과 (0.02ms, 63.9MB)
테스트 18 〉	통과 (0.02ms, 61.7MB)
테스트 19 〉	통과 (0.01ms, 64.1MB)
*/

class Solution1 {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        val (a, b, c) = slicer

        return when (n) {
            1 -> num_list.copyOfRange(0, b + 1)          // 0번부터 b번까지
            2 -> num_list.copyOfRange(a, num_list.size)  // a번부터 끝까지
            3 -> num_list.copyOfRange(a, b + 1)          // a번부터 b번까지
            4 -> (a..b step c).map { num_list[it] }.toIntArray() // a번부터 b번까지 c 간격으로
            else -> intArrayOf()                         // 예외 처리 (n은 항상 1~4이므로 실행되지 않음)
        }
    }
}

/*
테스트 1 〉	통과 (10.86ms, 66.3MB)
테스트 2 〉	통과 (9.83ms, 65.8MB)
테스트 3 〉	통과 (13.29ms, 63.1MB)
테스트 4 〉	통과 (9.42ms, 66.4MB)
테스트 5 〉	통과 (13.72ms, 64.9MB)
테스트 6 〉	통과 (9.95ms, 64.7MB)
테스트 7 〉	통과 (12.84ms, 65.7MB)
테스트 8 〉	통과 (9.52ms, 65.6MB)
테스트 9 〉	통과 (13.33ms, 65.5MB)
테스트 10 〉	통과 (15.39ms, 64.7MB)
테스트 11 〉	통과 (10.84ms, 67.9MB)
테스트 12 〉	통과 (13.13ms, 65.4MB)
테스트 13 〉	통과 (11.15ms, 66.1MB)
테스트 14 〉	통과 (9.14ms, 66.4MB)
테스트 15 〉	통과 (11.29ms, 65.3MB)
테스트 16 〉	통과 (9.37ms, 65.7MB)
테스트 17 〉	통과 (9.75ms, 65.7MB)
테스트 18 〉	통과 (15.31ms, 64.4MB)
테스트 19 〉	통과 (9.43ms, 64.7MB)
*/


class Solution2 {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        val (a, b, c) = slicer
        // n에 따라 슬라이싱
        return when(n){
            1 -> num_list.slice(0..b).toIntArray()
            2 -> num_list.slice(a until num_list.size).toIntArray()
            3 -> num_list.slice(a..b).toIntArray()
            4 -> num_list.slice(a..b step c).toIntArray()
            else -> intArrayOf()
        }
    }
}

/*
테스트 1 〉	통과 (23.40ms, 66.4MB)
테스트 2 〉	통과 (22.33ms, 66.6MB)
테스트 3 〉	통과 (22.52ms, 66.6MB)
테스트 4 〉	통과 (22.53ms, 65.8MB)
테스트 5 〉	통과 (22.50ms, 66.5MB)
테스트 6 〉	통과 (24.42ms, 66.8MB)
테스트 7 〉	통과 (23.41ms, 66.3MB)
테스트 8 〉	통과 (23.68ms, 66.8MB)
테스트 9 〉	통과 (21.82ms, 67.1MB)
테스트 10 〉	통과 (32.29ms, 66MB)
테스트 11 〉	통과 (25.78ms, 66.3MB)
테스트 12 〉	통과 (23.70ms, 66.7MB)
테스트 13 〉	통과 (26.86ms, 66.4MB)
테스트 14 〉	통과 (27.40ms, 66.7MB)
테스트 15 〉	통과 (22.30ms, 66.1MB)
테스트 16 〉	통과 (25.28ms, 66.1MB)
테스트 17 〉	통과 (21.83ms, 66.5MB)
테스트 18 〉	통과 (23.61ms, 66.1MB)
테스트 19 〉	통과 (22.33ms, 65.8MB)
*/