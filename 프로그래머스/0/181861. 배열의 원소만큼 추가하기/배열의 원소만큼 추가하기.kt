class Solution1 {
    fun solution(arr: IntArray): IntArray {
        val ret = IntArray(arr.sum()) // 결과 배열 생성
        var index = 0
        for (a in arr) {
            // a를 배열에 채우기
            repeat(a) {
                ret[index++] = a
            }
        }
        return ret
    }
}

/*
테스트 1 〉	통과 (16.27ms, 65.7MB)
테스트 2 〉	통과 (14.96ms, 65MB)
테스트 3 〉	통과 (19.68ms, 65.3MB)
테스트 4 〉	통과 (16.18ms, 64.5MB)
테스트 5 〉	통과 (16.71ms, 65.9MB)
테스트 6 〉	통과 (14.28ms, 65.6MB)
테스트 7 〉	통과 (15.36ms, 65.4MB)
테스트 8 〉	통과 (19.13ms, 65.1MB)
테스트 9 〉	통과 (15.76ms, 65.2MB)
테스트 10 〉	통과 (16.07ms, 65.9MB)
테스트 11 〉	통과 (20.31ms, 65.9MB)
테스트 12 〉	통과 (14.01ms, 65.4MB)
테스트 13 〉	통과 (20.97ms, 67.3MB)
테스트 14 〉	통과 (14.74ms, 65.5MB)
테스트 15 〉	통과 (15.48ms, 65.1MB)
테스트 16 〉	통과 (21.76ms, 63.8MB)
*/

class Solution2 {
    fun solution(arr: IntArray): IntArray {
        // 결과 배열의 크기는 arr의 합
        val retSize = arr.sum()
        val ret = IntArray(retSize) // retSize 크기의 배열 생성
        var index = 0

        // arr의 각 원소를 처리
        for (a in arr) {
            for (k in index until index + a) {
                ret[k] = a // 배열에 a를 채우기
            }
            index += a // 인덱스 이동
        }

        return ret
    }
}
/*
테스트 1 〉	통과 (16.07ms, 65.9MB)
테스트 2 〉	통과 (15.28ms, 65.9MB)
테스트 3 〉	통과 (19.78ms, 65.2MB)
테스트 4 〉	통과 (15.35ms, 65.4MB)
테스트 5 〉	통과 (13.62ms, 66.1MB)
테스트 6 〉	통과 (14.26ms, 66.2MB)
테스트 7 〉	통과 (14.34ms, 66.5MB)
테스트 8 〉	통과 (14.45ms, 65.3MB)
테스트 9 〉	통과 (14.65ms, 65.5MB)
테스트 10 〉	통과 (13.64ms, 65.4MB)
테스트 11 〉	통과 (13.82ms, 65.3MB)
테스트 12 〉	통과 (14.18ms, 65.3MB)
테스트 13 〉	통과 (18.20ms, 67.5MB)
테스트 14 〉	통과 (14.05ms, 65.3MB)
테스트 15 〉	통과 (14.27ms, 65.5MB)
테스트 16 〉	통과 (14.42ms, 65.7MB)
*/

class Solution0 {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val list = mutableListOf<Int>()
        for(a in arr){
            for(k in 0 until a){
                list.add(a)
            }
        }
        return list.toIntArray()
    }
}

/*
테스트 1 〉	통과 (6.44ms, 64.2MB)
테스트 2 〉	통과 (6.03ms, 64MB)
테스트 3 〉	통과 (5.92ms, 64MB)
테스트 4 〉	통과 (6.75ms, 64.5MB)
테스트 5 〉	통과 (6.82ms, 64.8MB)
테스트 6 〉	통과 (12.71ms, 63MB)
테스트 7 〉	통과 (7.84ms, 63.8MB)
테스트 8 〉	통과 (8.99ms, 64MB)
테스트 9 〉	통과 (10.31ms, 63.3MB)
테스트 10 〉	통과 (7.83ms, 65.2MB)
테스트 11 〉	통과 (6.75ms, 64.7MB)
테스트 12 〉	통과 (9.62ms, 64MB)
테스트 13 〉	통과 (12.51ms, 65.2MB)
테스트 14 〉	통과 (9.38ms, 63.8MB)
테스트 15 〉	통과 (8.03ms, 62.3MB)
테스트 16 〉	통과 (8.41ms, 64.5MB)
*/

class Solution {
    fun solution(arr: IntArray): List<Int> {
        return arr.flatMap { i -> List(i) { i } }
    }
}