class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
            val charArray = my_string.toCharArray()
        
            for((s, e) in queries){
                var left = s
                var right = e
                
                while(left < right){
                    val temp = charArray[left]
                    charArray[left] = charArray[right]
                    charArray[right] = temp
                    left ++
                    right --
                }
                
            }
            return String(charArray)
        }
}


class Solution2 {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        val charList = my_string.toMutableList()
        
        for((s, e) in queries){
            charList.subList(s, e+1).reverse()
        }
        return charList.joinToString("")
    }
}

/*
테스트 1 〉	통과 (19.44ms, 63.6MB)
테스트 2 〉	통과 (13.35ms, 64.3MB)
테스트 3 〉	통과 (18.64ms, 64.7MB)
테스트 4 〉	통과 (13.94ms, 64.9MB)
테스트 5 〉	통과 (15.26ms, 65.6MB)
테스트 6 〉	통과 (13.38ms, 65.2MB)
테스트 7 〉	통과 (14.51ms, 65MB)
테스트 8 〉	통과 (14.93ms, 65.2MB)
테스트 9 〉	통과 (15.11ms, 65.2MB)
테스트 10 〉	통과 (19.06ms, 65.2MB)
테스트 11 〉	통과 (15.96ms, 64.5MB)
테스트 12 〉	통과 (15.63ms, 64.7MB)
테스트 13 〉	통과 (14.24ms, 64.8MB)
테스트 14 〉	통과 (22.85ms, 66MB)
테스트 15 〉	통과 (16.17ms, 64.6MB)
테스트 16 〉	통과 (20.73ms, 63.4MB)
테스트 17 〉	통과 (28.51ms, 63.6MB)
테스트 18 〉	통과 (21.98ms, 65MB)
테스트 19 〉	통과 (22.82ms, 64.7MB)
테스트 20 〉	통과 (17.11ms, 64MB)
테스트 21 〉	통과 (21.28ms, 64.7MB)
테스트 22 〉	통과 (15.65ms, 65.3MB)
테스트 23 〉	통과 (19.59ms, 64.9MB)
테스트 24 〉	통과 (19.66ms, 64.9MB)
테스트 25 〉	통과 (28.53ms, 65.6MB)
*/