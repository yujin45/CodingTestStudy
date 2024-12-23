class Solution {
    fun solution(my_string: String): Array<String> {
        val ret = my_string.split(" ") // 공백으로 문자열 분리
        return ret.toTypedArray() // 리스트를 배열로 변환
    }
}
