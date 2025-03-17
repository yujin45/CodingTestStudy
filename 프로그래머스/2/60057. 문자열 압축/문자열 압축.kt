class Solution {
    fun solution(s: String): Int {

        val origin = StringBuilder(s)
        var minLength = s.length
        for(range in 1..origin.length/2){
            // 한 스탭 끝날 때마다 초기화 
            // 절반까지 진행하면 됨
            var temp = ""
            var count = 1
            val sb = StringBuilder()
            for(i in 0 until origin.length step (range)){
                if(i+range <= origin.length){
                    // 
                    val current = origin.substring(i, i+range)
                    if(current != temp){
                        if(count!=1) sb.append(count)
                        sb.append(temp)
                        temp = current
                        count = 1
                    }else{
                        count++
                    }
                }else{
                    // 뒤에 붙이기
                    sb.append(origin.substring(i))
                }

            }
            // 마지막 처리
            if(count!=1) sb.append(count)
            sb.append(temp)
            minLength = minOf(minLength, sb.length) 
        }

        return minLength
    }
}