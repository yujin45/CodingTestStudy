class Solution {
    fun solution(myStr: String): Array<String> {
        val sb = StringBuilder()
        val list = mutableListOf<String>() // 빈 리스트 생성
        for (m in myStr) {
            if (m != 'a' && m != 'b' && m != 'c') {
                sb.append(m) // 구분자가 아니면 StringBuilder에 추가
            } else {
                if (sb.isNotEmpty()) { // StringBuilder가 비어있지 않으면 리스트에 추가
                    list.add(sb.toString())
                    sb.clear() // StringBuilder 초기화
                }
            }
        }
        // 마지막 남은 문자열 추가
        if (sb.isNotEmpty()) {
            list.add(sb.toString())
        }

        // 리스트가 비어있으면 ["EMPTY"], 그렇지 않으면 배열로 변환
        return if (list.isEmpty()) arrayOf("EMPTY") else list.toTypedArray()
    }
}
