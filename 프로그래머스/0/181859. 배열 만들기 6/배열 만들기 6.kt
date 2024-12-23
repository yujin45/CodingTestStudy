import java.util.Deque
import java.util.ArrayDeque

class Solution {
    fun solution(arr: IntArray): IntArray {
        val stk = mutableListOf<Int>() // 스택 역할을 하는 리스트

        for (num in arr) {
            if (stk.isNotEmpty() && stk.last() == num) {
                stk.removeAt(stk.size - 1) // 마지막 원소 제거
            } else {
                stk.add(num) // 현재 원소 추가
            }
        }

        return if (stk.isEmpty()) intArrayOf(-1) else stk.toIntArray()
    }
}


/*
테스트 1 〉	통과 (6.41ms, 63.2MB)
테스트 2 〉	통과 (6.07ms, 64.5MB)
테스트 3 〉	통과 (5.93ms, 63MB)
테스트 4 〉	통과 (5.79ms, 64.4MB)
테스트 5 〉	통과 (5.95ms, 64.2MB)
테스트 6 〉	통과 (6.13ms, 63.7MB)
테스트 7 〉	통과 (6.72ms, 63.3MB)
테스트 8 〉	통과 (7.37ms, 64.3MB)
테스트 9 〉	통과 (5.85ms, 63.7MB)
테스트 10 〉	통과 (9.28ms, 63.1MB)
테스트 11 〉	통과 (6.30ms, 64.2MB)
테스트 12 〉	통과 (14.92ms, 64.9MB)
테스트 13 〉	통과 (22.13ms, 67.5MB)
테스트 14 〉	통과 (12.22ms, 62.3MB)
테스트 15 〉	통과 (11.04ms, 65.2MB)
테스트 16 〉	통과 (24.56ms, 67.5MB)
테스트 17 〉	통과 (32.58ms, 66.7MB)
테스트 18 〉	통과 (21.49ms, 69.4MB)
테스트 19 〉	통과 (47.05ms, 108MB)
테스트 20 〉	통과 (19.70ms, 66MB)
*/

class Solution2 {
    fun solution(arr: IntArray): IntArray {
        val stk: Deque<Int> = ArrayDeque()
        
        var i = 0
        while(i < arr.size){
            if(stk.isEmpty()){
                stk.push(arr[i])
                i++
            }else{
                if(stk.peek() == arr[i]){
                    stk.pop()
                    i++
                }else{
                    stk.push(arr[i])
                    i++
                }
            }
        }
        
        return if (stk.isEmpty()) intArrayOf(-1) else stk.toIntArray().reversedArray()
    }
}

/*
테스트 1 〉	통과 (0.09ms, 63.3MB)
테스트 2 〉	통과 (20.34ms, 66.6MB)
테스트 3 〉	통과 (0.10ms, 62.9MB)
테스트 4 〉	통과 (19.34ms, 67.8MB)
테스트 5 〉	통과 (20.24ms, 65.6MB)
테스트 6 〉	통과 (27.09ms, 65.8MB)
테스트 7 〉	통과 (19.81ms, 65.2MB)
테스트 8 〉	통과 (19.90ms, 65.7MB)
테스트 9 〉	통과 (0.11ms, 62.7MB)
테스트 10 〉	통과 (21.54ms, 65.1MB)
테스트 11 〉	통과 (23.66ms, 65.9MB)
테스트 12 〉	통과 (24.08ms, 67MB)
테스트 13 〉	통과 (26.92ms, 66.8MB)
테스트 14 〉	통과 (23.56ms, 66.5MB)
테스트 15 〉	통과 (28.65ms, 66.1MB)
테스트 16 〉	통과 (32.78ms, 69.3MB)
테스트 17 〉	통과 (37.18ms, 69.9MB)
테스트 18 〉	통과 (37.42ms, 71.8MB)
테스트 19 〉	통과 (65.65ms, 111MB)
테스트 20 〉	통과 (28.89ms, 70MB)
*/