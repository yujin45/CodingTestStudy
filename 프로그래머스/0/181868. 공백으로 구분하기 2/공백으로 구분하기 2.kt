class Solution {
    fun solution(my_string: String): Array<String> {
        return my_string.trim().split("\\s+".toRegex()).toTypedArray()
    }
}

class Solution2 {
    fun solution(my_string: String): Array<String> {
        return my_string.split(" ").filterNot{it==""}.toTypedArray()
    }
}

/*
테스트 1 〉	통과 (7.43ms, 63MB)
테스트 2 〉	통과 (7.10ms, 65MB)
테스트 3 〉	통과 (7.80ms, 64.7MB)
테스트 4 〉	통과 (6.97ms, 63.6MB)
테스트 5 〉	통과 (7.45ms, 64.5MB)
테스트 6 〉	통과 (7.96ms, 64.3MB)
테스트 7 〉	통과 (10.36ms, 63.8MB)
테스트 8 〉	통과 (8.33ms, 64.2MB)
테스트 9 〉	통과 (8.07ms, 63.8MB)
테스트 10 〉	통과 (11.36ms, 64.3MB)
*/