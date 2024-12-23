import kotlin.math.abs

class Solution {
    fun solution(a: Int, b: Int): Int {
        return when{
            a%2==1 && b%2==1 -> a*a + b*b
            a%2==1 || b%2==1 -> 2*(a+b)
            else -> abs(a-b)
        }
    }
}