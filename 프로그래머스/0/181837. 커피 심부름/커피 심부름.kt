class Solution {
    fun solution(order: Array<String>): Int {
        var answer: Int = 0
        val latte = arrayOf("icecafelatte", "cafelatteice", "hotcafelatte", "cafelattehot", "cafelatte")
        for(o in order){
            if(o in latte){
                answer+=5000
            }else{
                answer+=4500
            }
        }
        return answer
    }
}