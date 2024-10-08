class Solution {
    fun solution(numbers: IntArray): Int {
        return (0..9).filter{it !in numbers}.sum()
    }
}


class Solution1 {
    fun solution(numbers: IntArray): Int {
        var sum: Int = 0
        val range = (0..9)
        range.map{it -> if(it !in numbers) sum += it}
        return sum
    }
}