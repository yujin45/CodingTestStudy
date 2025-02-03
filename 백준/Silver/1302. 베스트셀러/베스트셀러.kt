package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    // 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력
    val map = HashMap<String, Int>()
    var maxCount = 0
    var bestSeller = ""
    repeat(n) {
        val title = br.readLine()
        val count = map.getOrDefault(title, 0) + 1
        map[title] = count
        if (count > maxCount || (count == maxCount && title < bestSeller)) {
            // maxCount보다 크거나 || 같은데 사전순이 더 앞이면
            maxCount = count
            bestSeller = title
        }
    }
    println(bestSeller)
    br.close()
}
