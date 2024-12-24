class Solution {
    fun solution(board: Array<IntArray>, k: Int): Int {
        var sum = 0
         val rows = board.size
        val cols = board[0].size

        for (i in 0 until rows) {
            for (j in 0..minOf(k - i, cols - 1)) { // 탐색 범위 축소
                sum += board[i][j]
            }
        }
        return sum
    }
}

class Solution2 {
    fun solution(board: Array<IntArray>, k: Int): Int {
        var sum = 0
        for(i in 0 until board.size){
            for(j in 0 until board[0].size){
                if((i+j) <=k){
                    sum+=board[i][j]
                }
            }
        }
        return sum
    }
}

/*
테스트 1 〉	통과 (0.03ms, 63.3MB)
테스트 2 〉	통과 (0.02ms, 62.3MB)
테스트 3 〉	통과 (0.02ms, 63.3MB)
테스트 4 〉	통과 (0.03ms, 61.1MB)
테스트 5 〉	통과 (0.02ms, 63.2MB)
테스트 6 〉	통과 (0.02ms, 63.8MB)
테스트 7 〉	통과 (0.07ms, 63.4MB)
테스트 8 〉	통과 (0.02ms, 64.1MB)
테스트 9 〉	통과 (0.03ms, 64.1MB)
*/