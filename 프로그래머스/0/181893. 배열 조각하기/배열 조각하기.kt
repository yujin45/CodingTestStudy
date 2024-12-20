class Solution {
    fun solution(arr: IntArray, query: IntArray): IntArray {
        var answer: IntArray = arr.clone()

        for (i in query.indices) {
            answer = if (i % 2 == 0) {
                // 짝수 인덱스: query[i] 뒤를 자름
                answer.sliceArray(0..query[i])
            } else {
                // 홀수 인덱스: query[i] 앞을 자름
                answer.sliceArray(query[i] until answer.size)
            }
        }

        return answer
    }
}
