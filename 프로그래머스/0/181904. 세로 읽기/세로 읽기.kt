class Solution {
    fun solution(my_string: String, m: Int, c: Int): String {
        // 2차원 배열 선언 및 초기화
        val rows = my_string.length / m
        val table = Array(rows) { rowIndex ->
            my_string.substring(rowIndex * m, (rowIndex + 1) * m).toCharArray()
        }

        // c번째 열의 문자들을 모아 문자열로 변환
        val columnChars = StringBuilder()
        for (row in table) {
            columnChars.append(row[c - 1]) // c번째 열은 c - 1 인덱스
        }

        return columnChars.toString()
    }
}
