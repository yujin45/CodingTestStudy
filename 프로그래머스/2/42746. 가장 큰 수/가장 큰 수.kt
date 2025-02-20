import java.util.Comparator

class Solution {
    fun solution(numbers: IntArray): String {
        // 1. 숫자 배열을 문자열로 변환
        val strNumbers = mutableListOf<String>()
        for(num in numbers){
            strNumbers.add(num.toString())
        }

        // 2. 정렬 기준 설정: (b+a) 가 (a+b)보다 크면 b가 앞으로 오도록 설정
        // 3+30 > 30+3 : 이 경우 3 30 순서
        val sortedNumbers = strNumbers.sortedWith(Comparator{
            a, b ->
            (b + a).compareTo(a+b) // 내림차순 정렬
        })

        // 3. 정렬된 것 이어붙여 결과 생성
        val sb = StringBuilder()
        sortedNumbers.forEach{sb.append(it)}
        val result = sb.toString()
        //println(result)
        // 4. "000" 같은 경우 "0"으로 변환
        return if(result.startsWith("0")) "0" else result
    }
}