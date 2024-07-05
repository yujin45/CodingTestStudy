class Solution {
    fun solution(arr: IntArray): IntArray {
        // flatMap은 하나의 큰 리스트로 합쳐지는 것
        // List(num)으로 크기가 num인 리스트 생성 {num}은 각 인덱스에서 실행되는 람다 함수로 모든 요소 num이 되도록 함
        return arr.flatMap{ num -> List(num) {num}}.toIntArray()
        
        // 내가 푼 것 조금 수정
        val result = mutableListOf<Int>()

        for (num in arr) {
            for (i in 1..num) { // 1부터 num까지
                result.add(num)
            }
        }

        return result.toIntArray()        
        // 내가 푼거
        var answer = mutableListOf<Int>()
        for (a in arr){
            for(i in 0 .. a-1){
                answer.add(a)
            }
        }
        return answer.toIntArray()
    }
}