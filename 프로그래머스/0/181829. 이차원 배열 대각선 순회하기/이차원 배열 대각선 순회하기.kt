class Solution {
    fun solution(board: Array<IntArray>, k: Int): Int {
        var sum : Int = 0
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