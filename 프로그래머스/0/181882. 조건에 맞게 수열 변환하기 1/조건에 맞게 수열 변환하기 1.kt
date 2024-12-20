class Solution {
    fun solution(arr: IntArray): IntArray {
        val ret = IntArray(arr.size)
        for(i in arr.indices){
            val it = arr[i]
            when{
                it >= 50 && it%2==0 -> ret[i] = it/2
                it < 50 && it%2 ==1 -> ret[i] =  it*2
                else -> ret[i] = it
            }
        }
        return ret
    }
}

class Solution2 {
    fun solution(arr: IntArray): IntArray {
        return arr.map{
            when{
                it >= 50 && it%2==0 -> it/2
                it < 50 && it%2 ==1 -> it*2
                else -> it
            }
        }.toIntArray()
    }
}

/*
테스트 1 〉	통과 (6.19ms, 64.5MB)
테스트 2 〉	통과 (5.86ms, 64MB)
테스트 3 〉	통과 (6.55ms, 64MB)
테스트 4 〉	통과 (7.02ms, 63.6MB)
테스트 5 〉	통과 (7.29ms, 63.7MB)
테스트 6 〉	통과 (6.89ms, 64.8MB)
테스트 7 〉	통과 (6.23ms, 65.5MB)
테스트 8 〉	통과 (6.30ms, 64.5MB)
테스트 9 〉	통과 (5.90ms, 64.2MB)
테스트 10 〉	통과 (46.47ms, 150MB)
테스트 11 〉	통과 (20.40ms, 87.7MB)
*/