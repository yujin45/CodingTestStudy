class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val hashMap = hashMapOf<String, Int>()
        for(c in clothes){
            val category = c[1]
            hashMap[category] = hashMap.getOrDefault(category, 0) + 1
        }
        
        val totalCombinations = hashMap.values.fold(1){acc, count -> acc*(count+1)}
        return totalCombinations - 1
    }
}

/*
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.09ms, 63.6MB)
테스트 2 〉	통과 (0.10ms, 64MB)
테스트 3 〉	통과 (0.09ms, 62.9MB)
테스트 4 〉	통과 (0.10ms, 62.6MB)
테스트 5 〉	통과 (0.09ms, 62.6MB)
테스트 6 〉	통과 (0.09ms, 63.1MB)
테스트 7 〉	통과 (0.15ms, 62.9MB)
테스트 8 〉	통과 (0.10ms, 63.4MB)
테스트 9 〉	통과 (0.08ms, 64.7MB)
테스트 10 〉	통과 (0.08ms, 63.7MB)
테스트 11 〉	통과 (0.09ms, 62.5MB)
테스트 12 〉	통과 (0.10ms, 63MB)
테스트 13 〉	통과 (0.09ms, 63.3MB)
테스트 14 〉	통과 (0.08ms, 60.8MB)
테스트 15 〉	통과 (0.08ms, 61.1MB)
테스트 16 〉	통과 (0.06ms, 61.4MB)
테스트 17 〉	통과 (0.14ms, 62.4MB)
테스트 18 〉	통과 (0.10ms, 64.5MB)
테스트 19 〉	통과 (0.09ms, 64.6MB)
테스트 20 〉	통과 (0.08ms, 64.5MB)
테스트 21 〉	통과 (0.08ms, 62.6MB)
테스트 22 〉	통과 (0.08ms, 63.2MB)
테스트 23 〉	통과 (0.08ms, 63.2MB)
테스트 24 〉	통과 (0.09ms, 63.4MB)
테스트 25 〉	통과 (0.09ms, 64MB)
테스트 26 〉	통과 (0.09ms, 61.5MB)
테스트 27 〉	통과 (0.08ms, 63.7MB)
테스트 28 〉	통과 (0.15ms, 65MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/

class Solution2 {
    fun solution(clothes: Array<Array<String>>): Int {
       val categoryCount = clothes.groupBy{it[1]}.mapValues{it.value.size}
       val totalCombinations = categoryCount.values.fold(1){acc, count -> acc*(count+1)}
       return totalCombinations -1
       
    }
}

/*
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (2.81ms, 61.3MB)
테스트 2 〉	통과 (2.73ms, 62.9MB)
테스트 3 〉	통과 (2.17ms, 63.2MB)
테스트 4 〉	통과 (2.34ms, 62.5MB)
테스트 5 〉	통과 (3.00ms, 63.4MB)
테스트 6 〉	통과 (2.88ms, 61.3MB)
테스트 7 〉	통과 (3.55ms, 61.8MB)
테스트 8 〉	통과 (2.50ms, 64.1MB)
테스트 9 〉	통과 (3.20ms, 62.4MB)
테스트 10 〉	통과 (3.35ms, 63.7MB)
테스트 11 〉	통과 (2.54ms, 63MB)
테스트 12 〉	통과 (2.63ms, 63.2MB)
테스트 13 〉	통과 (2.34ms, 64.6MB)
테스트 14 〉	통과 (2.30ms, 63.5MB)
테스트 15 〉	통과 (3.37ms, 63.8MB)
테스트 16 〉	통과 (2.35ms, 63.9MB)
테스트 17 〉	통과 (2.29ms, 64.3MB)
테스트 18 〉	통과 (2.30ms, 62.2MB)
테스트 19 〉	통과 (2.25ms, 63.5MB)
테스트 20 〉	통과 (3.24ms, 63.5MB)
테스트 21 〉	통과 (2.25ms, 65.2MB)
테스트 22 〉	통과 (2.48ms, 63.4MB)
테스트 23 〉	통과 (2.35ms, 62.8MB)
테스트 24 〉	통과 (2.26ms, 63.4MB)
테스트 25 〉	통과 (3.35ms, 63.6MB)
테스트 26 〉	통과 (2.55ms, 62.8MB)
테스트 27 〉	통과 (2.28ms, 63MB)
테스트 28 〉	통과 (2.23ms, 63.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

*/

class Solution1 {
    fun solution(clothes: Array<Array<String>>): Int {
        val hashMap = hashMapOf<String, Int>()
        for(c in clothes){
            val category = c[1]
            hashMap[category] = hashMap.getOrDefault(category, 0) + 1
        }
        
        var answer = 1
        for(hv in hashMap.values){
           answer *=(hv+1)
        }
        return answer-1
    }
}

/*
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.08ms, 64.2MB)
테스트 2 〉	통과 (0.09ms, 64MB)
테스트 3 〉	통과 (0.10ms, 61.3MB)
테스트 4 〉	통과 (0.15ms, 64.7MB)
테스트 5 〉	통과 (0.14ms, 62.7MB)
테스트 6 〉	통과 (0.13ms, 61.2MB)
테스트 7 〉	통과 (0.10ms, 62.7MB)
테스트 8 〉	통과 (0.12ms, 63MB)
테스트 9 〉	통과 (0.08ms, 61.6MB)
테스트 10 〉	통과 (0.13ms, 61.8MB)
테스트 11 〉	통과 (0.08ms, 64.2MB)
테스트 12 〉	통과 (0.10ms, 63.8MB)
테스트 13 〉	통과 (0.11ms, 62.7MB)
테스트 14 〉	통과 (0.13ms, 62.5MB)
테스트 15 〉	통과 (0.08ms, 63MB)
테스트 16 〉	통과 (0.09ms, 62.1MB)
테스트 17 〉	통과 (0.08ms, 61.1MB)
테스트 18 〉	통과 (0.11ms, 62.8MB)
테스트 19 〉	통과 (0.09ms, 63.1MB)
테스트 20 〉	통과 (0.12ms, 63.3MB)
테스트 21 〉	통과 (0.11ms, 62.4MB)
테스트 22 〉	통과 (0.11ms, 62.6MB)
테스트 23 〉	통과 (0.09ms, 64.5MB)
테스트 24 〉	통과 (0.10ms, 62.3MB)
테스트 25 〉	통과 (0.16ms, 61.6MB)
테스트 26 〉	통과 (0.10ms, 61.2MB)
테스트 27 〉	통과 (0.13ms, 62.7MB)
테스트 28 〉	통과 (0.10ms, 63.4MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

*/