class Solution {
    fun solution(num_list: IntArray): Int {
        var count : Int = 0
        var oneCheck : Int = 0
        while(true){
            oneCheck = 0
            for(i in num_list.indices){
                val num = num_list[i]
                num_list[i] = when {
                    num == 1 -> {
                        oneCheck++
                        1 // num_list[i]는 1로 유지
                    }
                    num % 2 == 0 -> {
                        count++
                        num / 2 // 짝수는 2로 나누기
                    }
                    else -> {
                        count++
                        (num - 1) / 2 // 홀수는 1을 빼고 2로 나누기
                    }
                }
            }
            if(oneCheck==num_list.size){return count}
        }

        return 0
    }
}