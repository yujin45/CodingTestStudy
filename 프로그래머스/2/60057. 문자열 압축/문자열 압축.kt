class Solution {
    fun solution(s: String): Int {
        val origin = s.toMutableList()
        var minLength = 1000
        for(k in 1 until s.length){
            val sb = StringBuilder()
            var check = origin.subList(0, k) // 초기 비교값
            var count = 1
            for(i in k until s.length step k){
                val sub : List<Char>
                if(i+k >= s.length){
                    sub = origin.subList(i, s.length)
                }else{
                    sub = origin.subList(i, i+k)
                }

                if(sub == check){
                    count++
                }else{
                    if(count!=1){
                        sb.append(count)    
                    }

                    check.forEach{sb.append(it)}
                    check = sub
                    count = 1
                }
            }
            if(count!=1){
                sb.append(count)    
            }
            check.forEach{sb.append(it)}
            minLength = minOf(sb.length, minLength)
        }
        minLength = minOf(minLength, s.length)
        return minLength
    }
}