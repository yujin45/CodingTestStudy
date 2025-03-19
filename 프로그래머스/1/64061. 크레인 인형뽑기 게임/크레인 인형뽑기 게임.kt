class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var count = 0
        val backet = mutableListOf<Int>()
        
        val topIndex = IntArray(board.size)
        for(col in board.indices){
            for(row in board.indices){
                if(board[row][col] !=0){
                    topIndex[col] = row
                    break
                }
            }
        }
        
        for(m in moves){
            val col = m-1
            val row = topIndex[col]
            
            
            if(row < board.size){
                val doll = board[row][col]
                if(backet.isNotEmpty() && backet.last()==doll){
                    backet.removeLast()
                    count+=2
                }else{
                    backet.add(doll)
                }
                board[row][col]=0
                topIndex[col]++
            }
        }
        
        return count
    }
}