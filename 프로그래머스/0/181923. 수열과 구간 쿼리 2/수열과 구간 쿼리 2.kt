class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        return queries.map{(s, e, k) -> 
            arr.slice(s..e) // 범위 s..e에 해당하는 배열 추출
               .filter{ it > k } // k보다 큰 값 필터링
               .minOrNull() ?: -1 // 가장 작은 값 반환, 없으면 -1
        }.toIntArray()
    }
}