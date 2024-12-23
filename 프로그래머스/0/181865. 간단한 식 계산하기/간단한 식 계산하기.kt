class Solution {
    fun solution(binomial: String): Int {
        val bin = binomial.split(" ")
        val num1 = bin[0].toInt()
        val num2 = bin[2].toInt()
        return when(bin[1]){
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            else -> 0
        }
    }
}