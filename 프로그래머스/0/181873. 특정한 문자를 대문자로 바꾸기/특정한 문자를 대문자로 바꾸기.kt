class Solution {
    fun solution(my_string: String, alp: String): String {
        val targetChar = alp[0] // `alp`는 항상 1글자이므로 첫 번째 문자만 가져옴
        val result = StringBuilder()

        for (char in my_string) {
            if (char == targetChar) {
                result.append(char.uppercaseChar()) // 대문자로 변환
            } else {
                result.append(char) // 그대로 추가
            }
        }

        return result.toString()
    }
}


class Solution2 {
    fun solution(my_string: String, alp: String): String {
        return my_string.replace(alp, alp.uppercase())
    }
}

/*
테스트 1 〉	통과 (7.77ms, 62.5MB)
테스트 2 〉	통과 (9.06ms, 61MB)
테스트 3 〉	통과 (7.09ms, 60.8MB)
테스트 4 〉	통과 (8.34ms, 61.2MB)
테스트 5 〉	통과 (8.15ms, 61MB)
테스트 6 〉	통과 (8.34ms, 62MB)
테스트 7 〉	통과 (8.27ms, 61.3MB)
테스트 8 〉	통과 (7.70ms, 61.7MB)
테스트 9 〉	통과 (7.69ms, 61.7MB)
테스트 10 〉	통과 (7.53ms, 62.4MB)
테스트 11 〉	통과 (11.79ms, 61.3MB)
테스트 12 〉	통과 (8.59ms, 60.6MB)
테스트 13 〉	통과 (7.71ms, 63.1MB)
테스트 14 〉	통과 (7.75ms, 61.7MB)
테스트 15 〉	통과 (7.95ms, 60.7MB)
테스트 16 〉	통과 (7.83ms, 61.3MB)
테스트 17 〉	통과 (6.99ms, 61MB)
테스트 18 〉	통과 (6.84ms, 63.2MB)
테스트 19 〉	통과 (7.69ms, 61.2MB)
*/