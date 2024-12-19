class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        var answer: Int = 0
        
        
        val op = ineq+eq
        return when(op){
            ">=" -> if(n>=m) 1 else 0
            "<=" -> if(n<=m) 1 else 0
            ">!" -> if(n>m) 1 else 0
            "<!" -> if(n<m) 1 else 0
            else -> 0
        }
        
    }
}