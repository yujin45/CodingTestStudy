class Solution1 {
    fun solution(t: String, p: String): Int {
        var count: Int = 0
        for(i in 0..(t.length-p.length)){
            var sub = t.substring(i, i+ p.length)
            if(sub.toLong() <= p.toLong()){
                count++
            }
        }
        return count
    }
}


class Solution {
    fun solution(t: String, p: String): Int {
        val pValue = p.toLong()  // p를 Long으로 변환
        return (0..t.length - p.length)
            .count { t.substring(it, it + p.length).toLong() <= pValue }
    }
}
