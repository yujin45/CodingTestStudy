import java.math.BigInteger

class Solution {
    fun solution(a: String, b: String): String {
        return (BigInteger(a) + BigInteger(b)).toString()
    }
}