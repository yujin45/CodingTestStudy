class Solution {
    fun solution(arr: IntArray): Int {
        var count = 0

        while (true) {
            var isChanged = false // 변경 여부 추적

            for (i in arr.indices) {
                val check = arr[i]

                if (check >= 50 && check % 2 == 0) {
                    arr[i] = check / 2
                    isChanged = true
                } else if (check < 50 && check % 2 == 1) {
                    arr[i] = check * 2 + 1
                    isChanged = true
                }
            }

            if (!isChanged) return count // 변경이 없으면 반복 종료
            count++
        }
    }
}

/*
테스트 1 〉	통과 (0.02ms, 63.6MB)
테스트 2 〉	통과 (0.03ms, 62.8MB)
테스트 3 〉	통과 (0.02ms, 62.1MB)
테스트 4 〉	통과 (0.03ms, 62.7MB)
테스트 5 〉	통과 (0.02ms, 63.3MB)
테스트 6 〉	통과 (0.04ms, 63.4MB)
테스트 7 〉	통과 (0.16ms, 64.9MB)
테스트 8 〉	통과 (0.26ms, 63.7MB)
테스트 9 〉	통과 (0.11ms, 61.7MB)
테스트 10 〉	통과 (43.02ms, 108MB)
테스트 11 〉	통과 (7.99ms, 65.3MB)
테스트 12 〉	통과 (0.02ms, 62.8MB)
테스트 13 〉	통과 (0.02ms, 63.5MB)
*/

class MySolution {
    fun solution(arr: IntArray): Int {
        var count : Int = 0
        while(true){
            val temp = arr.copyOf()
            for(i in arr.indices){
                val check = arr[i]
                if(check >= 50 && check%2 ==0){
                    arr[i] = check/2
                }else if(check < 50 && check%2 ==1){
                    arr[i]=check*2 + 1
                }
            }
            if(arr.contentEquals(temp)){ return count}
            count++
        }

        return 0
    }
}

/*
테스트 1 〉	통과 (0.08ms, 63.1MB)
테스트 2 〉	통과 (0.05ms, 64.4MB)
테스트 3 〉	통과 (0.04ms, 63.6MB)
테스트 4 〉	통과 (0.17ms, 63.6MB)
테스트 5 〉	통과 (0.06ms, 64.7MB)
테스트 6 〉	통과 (0.10ms, 62.9MB)
테스트 7 〉	통과 (0.34ms, 64.4MB)
테스트 8 〉	통과 (0.54ms, 63.7MB)
테스트 9 〉	통과 (0.29ms, 63.2MB)
테스트 10 〉	통과 (63.68ms, 129MB)
테스트 11 〉	통과 (13.67ms, 67.1MB)
테스트 12 〉	통과 (0.03ms, 65.9MB)
테스트 13 〉	통과 (0.04ms, 61.6MB)
*/