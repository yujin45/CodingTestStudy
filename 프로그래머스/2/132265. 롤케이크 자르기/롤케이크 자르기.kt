class Solution {
    fun solution(topping: IntArray): Int {
        val a = HashSet<Int>() // 좌 -> 우
        val b = HashSet<Int>() // 좌 <- 우

        val n = topping.size
        val adp = IntArray(n)
        val bdp = IntArray(n)
        for(i in topping.indices){
            a.add(topping[i])
            b.add(topping[n-1-i])
            adp[i] = a.size
            bdp[n-1-i] = b.size
        }
        //println(adp.contentToString())
        //println(bdp.contentToString())
        var count =  0
        for(i in 0 until n-1){
            // i번째 뒤에 자르면
            if(adp[i] == bdp[i+1]){
                // \ 한 방향으로만 체크
                count++
            }
        }
        return count
    }
}