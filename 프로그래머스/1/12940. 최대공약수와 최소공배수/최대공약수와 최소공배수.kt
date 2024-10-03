class Solution {
    private fun gcd(a: Int, b: Int): Int{
        return if(b == 0) a else gcd(b, a%b)
    }
    
    private fun lcm(a: Int, b: Int):Int{
        return (a*b) / gcd(a, b)
    }
    
    fun solution(n: Int, m: Int): IntArray {
        return intArrayOf(gcd(n, m), lcm(n, m))
    }
}