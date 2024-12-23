class Solution1 {
    fun solution(my_string: String, target: String): Int {
        return if(my_string.contains(target)) 1 else 0
    }
}
/*
테스트 1 〉	통과 (6.78ms, 64.2MB)
테스트 2 〉	통과 (6.73ms, 61.7MB)
테스트 3 〉	통과 (6.80ms, 64MB)
테스트 4 〉	통과 (6.80ms, 64.5MB)
테스트 5 〉	통과 (9.99ms, 64.4MB)
테스트 6 〉	통과 (7.35ms, 62.7MB)
테스트 7 〉	통과 (6.82ms, 63MB)
테스트 8 〉	통과 (6.80ms, 64MB)
테스트 9 〉	통과 (6.55ms, 64.2MB)
테스트 10 〉	통과 (6.41ms, 63.5MB)
테스트 11 〉	통과 (7.05ms, 63.3MB)
테스트 12 〉	통과 (7.38ms, 64.5MB)
테스트 13 〉	통과 (7.13ms, 63.9MB)
테스트 14 〉	통과 (6.95ms, 64.4MB)
테스트 15 〉	통과 (7.10ms, 64.6MB)
테스트 16 〉	통과 (6.49ms, 62.6MB)
테스트 17 〉	통과 (6.60ms, 63.4MB)
테스트 18 〉	통과 (7.28ms, 63.5MB)
테스트 19 〉	통과 (6.51ms, 63.6MB)
테스트 20 〉	통과 (6.56ms, 64.4MB)
테스트 21 〉	통과 (6.52ms, 64MB)
*/

class Solution {
    fun solution(my_string: String, target: String): Int {
        return if(target in my_string) 1 else 0
    }
}