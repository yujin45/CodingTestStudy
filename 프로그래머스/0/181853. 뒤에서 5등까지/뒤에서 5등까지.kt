import java.util.PriorityQueue

class Solution { 
    fun solution(num_list: IntArray): IntArray {
        // 최소 힙 생성
        val minHeap = PriorityQueue<Int>()
        
        // num_list의 요소를 힙에 추가
        for (num in num_list) {
            minHeap.offer(num)
        }

        // 최소 힙에서 5개의 요소를 가져와 배열로 반환
        return IntArray(5) { minHeap.poll() }.sortedArray()
    }
}


class Solution1 {
    fun solution(num_list: IntArray): IntArray {
        // take함수
        //return num_list.sorted().take(5).toIntArray()
	      // 4까지 포함
		    //return num_list.sorted().slice(0 .. 4).toIntArray()
			   // 5는 미포함
        return num_list.sorted().slice(0 until 5).toIntArray()
    }
}
/*
take
테스트 1 〉	통과 (29.39ms, 66.2MB)
테스트 2 〉	통과 (30.85ms, 66MB)
테스트 3 〉	통과 (24.92ms, 66MB)
테스트 4 〉	통과 (21.08ms, 65.9MB)
slice ..
테스트 1 〉	통과 (21.40ms, 66MB)
테스트 2 〉	통과 (21.88ms, 66.4MB)
테스트 3 〉	통과 (22.18ms, 66.1MB)
테스트 4 〉	통과 (24.19ms, 65.3MB)
slice until
테스트 1 〉	통과 (21.73ms, 66.5MB)
테스트 2 〉	통과 (30.43ms, 66.6MB)
테스트 3 〉	통과 (24.70ms, 66.6MB)
테스트 4 〉	통과 (23.25ms, 66.7MB)
*/