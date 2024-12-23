class Solution {
    fun solution(arr: IntArray, k: Int): List<Int> {
        return (0 until k).map { if (it >= arr.toSet().size) -1 else arr.distinct()[it] }
    }
}

class Solution2 {
    fun solution(arr: IntArray, k: Int): IntArray {
        var ret: IntArray = IntArray(k){ -1 }
        val arrDis = arr.distinct()
        println(arrDis.indices)
        for(i in arrDis.indices){
            if(i == ret.size) break
            ret[i] = arrDis[i]
        }
        return ret
    }
}

/*
테스트 1 〉	통과 (28.02ms, 66.8MB)
테스트 2 〉	통과 (32.30ms, 66.8MB)
테스트 3 〉	통과 (36.26ms, 65.8MB)
테스트 4 〉	통과 (37.01ms, 66.4MB)
테스트 5 〉	통과 (23.17ms, 66.6MB)
테스트 6 〉	통과 (24.14ms, 67.4MB)
테스트 7 〉	통과 (27.47ms, 66.4MB)
테스트 8 〉	통과 (29.25ms, 66.6MB)
테스트 9 〉	통과 (35.74ms, 66.5MB)
테스트 10 〉	통과 (28.51ms, 67.1MB)
테스트 11 〉	통과 (26.20ms, 67.8MB)
테스트 12 〉	통과 (24.48ms, 67.7MB)
테스트 13 〉	통과 (26.66ms, 67.2MB)
테스트 14 〉	통과 (32.61ms, 67.3MB)
테스트 15 〉	통과 (30.59ms, 66.3MB)
테스트 16 〉	통과 (26.83ms, 75.4MB)
테스트 17 〉	통과 (31.29ms, 71.6MB)
테스트 18 〉	통과 (28.57ms, 71.6MB)
테스트 19 〉	통과 (27.03ms, 72.8MB)
테스트 20 〉	통과 (42.87ms, 72.6MB)
*/