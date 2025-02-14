class Solution {
    fun solution(p: String): String {
        if (p.isEmpty() || isCorrect(p)) return p
        return makeCorrect(p)
    }

    fun makeCorrect(w: String): String {
        if (w.isEmpty()) return ""

        // 1. u, v 분리
        val end = getBalancedIndex(w)
        val u = w.substring(0, end)
        val v = w.substring(end)

        // 2. u가 올바른 문자열이면 v를 재귀적으로 변환
        return if (isCorrect(u)) {
            u + makeCorrect(v)
        } else {
            // 4단계: 변환 수행
            "(" + makeCorrect(v) + ")" + reverseBrackets(u.substring(1, u.length - 1))
        }
    }

    // 균형잡힌 문자열의 끝 인덱스 찾기
    fun getBalancedIndex(w: String): Int {
        var count = 0
        for (i in w.indices) {
            count += if (w[i] == '(') 1 else -1
            if (count == 0) return i + 1
        }
        return w.length
    }

    // 올바른 괄호 문자열인지 확인
    fun isCorrect(p: String): Boolean {
        var count = 0
        for (ch in p) {
            if (ch == '(') count++
            else {
                if (count == 0) return false
                count--
            }
        }
        return count == 0
    }

    // 괄호 방향 반전
    fun reverseBrackets(s: String): String {
        return s.map { if (it == '(') ')' else '(' }.joinToString("")
    }
}
