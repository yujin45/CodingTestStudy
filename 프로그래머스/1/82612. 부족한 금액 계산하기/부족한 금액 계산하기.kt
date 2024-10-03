class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var totalPrice : Long = 0
        // N번째 이용 : price * N
        for(n in 1..count){
            totalPrice += price * n 
        }
        // 부족한 금액이 없으면 0, 있으면 차이를 반환
        return if (totalPrice > money) totalPrice - money else 0L
    }
}
