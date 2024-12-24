class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        val n = arr.size
        val m = arr[0].size
        if(n==m) return arr

        var k = maxOf(n, m)

        return Array(k){i ->
            IntArray(k){j ->
                if(i<n && j <m) arr[i][j] else 0
            }
        }
    }
}

class Solution2 {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        val n = arr.size
        val m = arr[0].size
        if(n==m) return arr

        var k = if(n>m) n else m

        val ret = Array<IntArray>(k){
            IntArray(k)}

        // 행의 수가 더 많다면 열의 수가 행과 같아지도록
        for(i in 0 until n){
            for(j in 0 until m){
                ret[i][j] = arr[i][j]
            }
        }

        return ret
    }
}
// 테스트 1 〉	통과 (0.03ms, 63.9MB)
// 테스트 2 〉	통과 (0.03ms, 63.1MB)
// 테스트 3 〉	통과 (0.05ms, 63.9MB)
// 테스트 4 〉	통과 (0.06ms, 66.1MB)
// 테스트 5 〉	통과 (0.08ms, 66.6MB)
// 테스트 6 〉	통과 (0.04ms, 62.6MB)
// 테스트 7 〉	통과 (0.03ms, 63MB)