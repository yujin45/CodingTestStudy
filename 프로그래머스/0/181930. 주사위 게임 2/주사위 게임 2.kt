class Solution1 {
    fun solution(a: Int, b: Int, c: Int): Int {
        return if(a != b && b != c && c != a){
            // 모두 다를 경우 
            a+b+c
        } else if(a == b && b == c){
            // 모두 같을 경우
             ( (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c))
        }else{
            // 2개만 같을 경우
           ((a + b + c) * (a*a + b*b + c*c))
        }
    }
}

class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        val sum = a + b + c
        val squareSum = a * a + b * b + c * c
        val cubeSum = a * a * a + b * b * b + c * c * c

        return when {
            a == b && b == c -> sum * squareSum * cubeSum // 세 숫자가 모두 같은 경우
            a == b || b == c || c == a -> sum * squareSum // 두 숫자가 같은 경우
            else -> sum // 세 숫자가 모두 다른 경우
        }
    }
}
