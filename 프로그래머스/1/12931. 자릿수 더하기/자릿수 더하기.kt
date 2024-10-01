class Solution {
    fun solution(n: Int): Int {
        
        return n.toString().map{ char -> char.toString().toInt()}.sum()
    }
}