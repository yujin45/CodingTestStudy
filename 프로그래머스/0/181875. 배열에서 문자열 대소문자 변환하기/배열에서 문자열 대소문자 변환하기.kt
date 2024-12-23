class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        strArr.forEachIndexed{i, v ->
        strArr[i] = if (i % 2 == 0) v.lowercase() else v.uppercase()}
        return strArr
    }
}