class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var sum = 0
        return numbers.fold(0) {acc, num ->
            if(acc > n) acc else acc + num
        }
    }
}
/*
테스트 1 〉	통과 (0.02ms, 62.8MB)
테스트 2 〉	통과 (0.02ms, 62.8MB)
테스트 3 〉	통과 (0.01ms, 64.2MB)
테스트 4 〉	통과 (0.01ms, 64.9MB)
테스트 5 〉	통과 (0.01ms, 62.3MB)
테스트 6 〉	통과 (0.01ms, 63.3MB)
테스트 7 〉	통과 (0.02ms, 64.1MB)
테스트 8 〉	통과 (0.01ms, 64.5MB)
테스트 9 〉	통과 (0.02ms, 63.4MB)
테스트 10 〉	통과 (0.02ms, 63.6MB)
테스트 11 〉	통과 (0.01ms, 64.3MB)
테스트 12 〉	통과 (0.01ms, 63.1MB)
*/

class Solution2 {
    fun solution(numbers: IntArray, n: Int): Int {
        var sum = 0
        for(i in 0 until numbers.size){
            sum += numbers[i]
            if(sum > n) return sum
        }
        return -1
    }
}

/*
테스트 1 〉	통과 (0.01ms, 63.7MB)
테스트 2 〉	통과 (0.01ms, 61.2MB)
테스트 3 〉	통과 (0.02ms, 65MB)
테스트 4 〉	통과 (0.02ms, 61.9MB)
테스트 5 〉	통과 (0.01ms, 61.9MB)
테스트 6 〉	통과 (0.01ms, 63MB)
테스트 7 〉	통과 (0.02ms, 62.7MB)
테스트 8 〉	통과 (0.02ms, 63.5MB)
테스트 9 〉	통과 (0.01ms, 62.4MB)
테스트 10 〉	통과 (0.01ms, 63.3MB)
테스트 11 〉	통과 (0.01ms, 60.8MB)
테스트 12 〉	통과 (0.01ms, 63.4MB)
*/