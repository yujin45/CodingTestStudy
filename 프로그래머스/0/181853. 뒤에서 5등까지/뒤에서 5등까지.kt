class Solution {
    fun solution(num_list: IntArray): IntArray {
        // take함수
        return num_list.sorted().take(5).toIntArray()
	      // 4까지 포함
		    return num_list.sorted().slice(0 .. 4).toIntArray()
			   // 5는 미포함
        return num_list.sorted().slice(0 until 5).toIntArray()
    }
}