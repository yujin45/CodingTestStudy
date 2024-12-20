class Solution {
    fun solution(str_list: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        for(i in str_list.indices){
            if(str_list[i]=="l"){
                return str_list.copyOfRange(0, i)
            }
            if(str_list[i]=="r"){
                return str_list.copyOfRange(i+1, str_list.size)
            }
        }
        return arrayOf<String>()
    }
}

/*
테스트 1 〉	통과 (9.61ms, 66.2MB)
테스트 2 〉	통과 (9.30ms, 65.3MB)
테스트 3 〉	통과 (13.79ms, 66.1MB)
테스트 4 〉	통과 (9.74ms, 66.3MB)
테스트 5 〉	통과 (13.40ms, 65.9MB)
테스트 6 〉	통과 (10.10ms, 66.7MB)
테스트 7 〉	통과 (10.39ms, 65MB)
테스트 8 〉	통과 (9.72ms, 65.5MB)
테스트 9 〉	통과 (14.17ms, 66.2MB)
테스트 10 〉	통과 (9.68ms, 66MB)
테스트 11 〉	통과 (9.58ms, 65.6MB)
테스트 12 〉	통과 (0.02ms, 63.2MB)
테스트 13 〉	통과 (12.98ms, 63.8MB)
테스트 14 〉	통과 (12.19ms, 66.3MB)
테스트 15 〉	통과 (9.74ms, 67.6MB)
테스트 16 〉	통과 (9.19ms, 66.1MB)
테스트 17 〉	통과 (9.39ms, 65.6MB)
테스트 18 〉	통과 (9.05ms, 66.2MB)
테스트 19 〉	통과 (0.02ms, 63.5MB)
*/
class Solution2 {
    fun solution(str_list: Array<String>): Array<String> {
        for (i in str_list.indices) {
            when (str_list[i]) {
                "l" -> return str_list.sliceArray(0 until i) // "l"의 왼쪽 부분 반환
                "r" -> return str_list.sliceArray(i + 1 until str_list.size) // "r"의 오른쪽 부분 반환
            }
        }
        return emptyArray() // "l"이나 "r"이 없는 경우 빈 배열 반환
    }
}

/*
테스트 1 〉	통과 (18.82ms, 65.1MB)
테스트 2 〉	통과 (16.59ms, 65.5MB)
테스트 3 〉	통과 (16.22ms, 65.1MB)
테스트 4 〉	통과 (16.39ms, 66.8MB)
테스트 5 〉	통과 (26.19ms, 65MB)
테스트 6 〉	통과 (16.78ms, 67.3MB)
테스트 7 〉	통과 (22.26ms, 65.5MB)
테스트 8 〉	통과 (20.16ms, 65.3MB)
테스트 9 〉	통과 (23.66ms, 65.7MB)
테스트 10 〉	통과 (16.55ms, 66MB)
테스트 11 〉	통과 (21.64ms, 65.2MB)
테스트 12 〉	통과 (0.02ms, 63.6MB)
테스트 13 〉	통과 (17.36ms, 65.4MB)
테스트 14 〉	통과 (16.91ms, 66.8MB)
테스트 15 〉	통과 (16.51ms, 65.3MB)
테스트 16 〉	통과 (25.52ms, 65.4MB)
테스트 17 〉	통과 (16.80ms, 65.9MB)
테스트 18 〉	통과 (16.47ms, 66.9MB)
테스트 19 〉	통과 (0.02ms, 64.6MB)
테스트 20 〉	통과 (17.19ms, 66.9MB)
*/
