class Solution {
    fun solution(strArr: Array<String>) = strArr.groupBy(String::length).values.maxOf(List<String>::size)
}

class Solution2 {
    fun solution(strArr: Array<String>): Int {
        val map = mutableMapOf<Int, Int>()
        for(s in strArr){
            map[s.length] = map.getOrDefault(s.length, 0)+1
        }
        
        //return map.values.maxOrNull() ?: 0 // 컬렉션이 비어 있을 가능성이 있다면
        return map.values.maxOf{it} // 컬렉션이 비어 있지 않음을 보장할 수 있다면 →
    }
}

/*
테스트 1 〉	통과 (21.40ms, 95.3MB)
테스트 2 〉	통과 (0.46ms, 62.8MB)
테스트 3 〉	통과 (27.07ms, 95.2MB)
테스트 4 〉	통과 (15.66ms, 94.2MB)
테스트 5 〉	통과 (13.59ms, 94.6MB)
테스트 6 〉	통과 (3.61ms, 78.6MB)
테스트 7 〉	통과 (20.40ms, 95.4MB)
테스트 8 〉	통과 (5.57ms, 79.9MB)
테스트 9 〉	통과 (16.24ms, 88.8MB)
테스트 10 〉	통과 (2.50ms, 76.9MB)
테스트 11 〉	통과 (1.86ms, 66.6MB)
테스트 12 〉	통과 (19.03ms, 92.6MB)
테스트 13 〉	통과 (18.37ms, 95.3MB)
테스트 14 〉	통과 (7.79ms, 82.2MB)
테스트 15 〉	통과 (10.41ms, 91.2MB)
테스트 16 〉	통과 (7.84ms, 83.3MB)
테스트 17 〉	통과 (10.16ms, 90.6MB)
테스트 18 〉	통과 (8.43ms, 87MB)
테스트 19 〉	통과 (11.19ms, 91.6MB)
테스트 20 〉	통과 (17.74ms, 96.9MB)
테스트 21 〉	통과 (19.17ms, 93.2MB)
테스트 22 〉	통과 (15.61ms, 93.8MB)
테스트 23 〉	통과 (9.16ms, 92MB)
테스트 24 〉	통과 (17.44ms, 94.6MB)
*/