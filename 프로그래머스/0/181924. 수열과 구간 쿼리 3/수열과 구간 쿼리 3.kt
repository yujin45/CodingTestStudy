class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for((i, j) in queries){
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
        
        return arr
    }
}
/*
테스트 1 〉	통과 (0.08ms, 63.1MB)
테스트 2 〉	통과 (0.04ms, 63MB)
테스트 3 〉	통과 (0.04ms, 62.7MB)
테스트 4 〉	통과 (0.03ms, 62.7MB)
테스트 5 〉	통과 (0.02ms, 64.3MB)
테스트 6 〉	통과 (0.02ms, 62.9MB)
테스트 7 〉	통과 (0.08ms, 63.8MB)
테스트 8 〉	통과 (0.05ms, 63.8MB)
테스트 9 〉	통과 (0.05ms, 63.3MB)
테스트 10 〉	통과 (0.04ms, 64.2MB)
테스트 11 〉	통과 (0.03ms, 64.4MB)
*/
class Solution2 {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { (i, j) ->
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
        return arr
    }
}

/*
테스트 1 〉	통과 (0.05ms, 64MB)
테스트 2 〉	통과 (0.03ms, 61.9MB)
테스트 3 〉	통과 (0.04ms, 62.7MB)
테스트 4 〉	통과 (0.02ms, 62.4MB)
테스트 5 〉	통과 (0.02ms, 63.4MB)
테스트 6 〉	통과 (0.02ms, 64.6MB)
테스트 7 〉	통과 (0.09ms, 65.8MB)
테스트 8 〉	통과 (0.07ms, 62.7MB)
테스트 9 〉	통과 (0.04ms, 63.4MB)
테스트 10 〉	통과 (0.09ms, 64MB)
테스트 11 〉	통과 (0.04ms, 63.3MB)
채점 결과
*/