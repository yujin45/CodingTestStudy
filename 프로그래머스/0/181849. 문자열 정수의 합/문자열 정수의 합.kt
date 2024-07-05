class Solution {
    fun solution(num_str: String): Int {
        return num_str.map{it.toString().toInt()}.sum()
        var answer : Int = 0
        for (n in num_str){
            answer += n.toString().toInt() 
            // toString으로 변환해줘야지 제대로 숫자 변환됨
        }
        return answer
    }
}