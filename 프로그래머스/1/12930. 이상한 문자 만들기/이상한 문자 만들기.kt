class Solution {
    fun solution(s: String): String {
        // 공백 기준으로 문자열을 분리해서 단어 리스트를 만듭니다.
        return s.split(" ").joinToString(" ") { word ->
            word.mapIndexed { index, c ->
                if (index % 2 == 0) c.uppercaseChar() else c.lowercaseChar()
            }.joinToString("")
        }
    }
}
