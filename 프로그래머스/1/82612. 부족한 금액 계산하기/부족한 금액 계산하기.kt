class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var total :Long = 0
        for(i in 1..count){
            total += i*price
        }
        //println("total: $total")
        val need = total - money
        return if(need >0) need else 0
    }
}