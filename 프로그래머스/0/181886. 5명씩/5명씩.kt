class Solution {
    fun solution(names: Array<String>): Array<String> {
        // 인덱스가 0, 5, 10... 5의 배수일 때 
        return names.filterIndexed{index, _ -> index%5==0 }.toTypedArray()
    }
}