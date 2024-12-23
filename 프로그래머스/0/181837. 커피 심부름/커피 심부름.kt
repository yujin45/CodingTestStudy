class Solution {
    fun solution(order: Array<String>): Int {
        return order.map { if (it.contains("cafelatte")) 5000 else 4500 }.sum()
    }
}

class Solution2 {
    fun solution(order: Array<String>): Int {
        var answer: Int = 0
        val latte = arrayOf("icecafelatte", "cafelatteice", "hotcafelatte", "cafelattehot", "cafelatte")
        for(o in order){
            if(o in latte){
                answer+=5000
            }else{
                answer+=4500
            }
        }
        return answer
    }
}

/*
테스트 1 〉	통과 (23.41ms, 63.3MB)
테스트 2 〉	통과 (14.07ms, 65MB)
테스트 3 〉	통과 (23.50ms, 65.2MB)
테스트 4 〉	통과 (14.17ms, 65.4MB)
테스트 5 〉	통과 (18.05ms, 65.7MB)
테스트 6 〉	통과 (29.30ms, 63.6MB)
테스트 7 〉	통과 (19.16ms, 65MB)
테스트 8 〉	통과 (21.86ms, 64.6MB)
테스트 9 〉	통과 (21.85ms, 65.1MB)
테스트 10 〉	통과 (21.94ms, 65MB)
테스트 11 〉	통과 (13.90ms, 64.8MB)
테스트 12 〉	통과 (15.60ms, 66.4MB)
테스트 13 〉	통과 (21.99ms, 64.3MB)
테스트 14 〉	통과 (17.50ms, 65.5MB)
테스트 15 〉	통과 (20.17ms, 66.9MB)
테스트 16 〉	통과 (14.67ms, 67.3MB)
테스트 17 〉	통과 (16.00ms, 66.9MB)
테스트 18 〉	통과 (18.77ms, 65.9MB)
테스트 19 〉	통과 (13.83ms, 65.8MB)
테스트 20 〉	통과 (14.42ms, 64.5MB)
*/