package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    // 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력
    val map = HashMap<String, Int>()
    repeat(n) {
        val title = br.readLine()
        map[title] = map.getOrDefault(title, 0) + 1
    }
    val sortedMap = map.entries.sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
    println(sortedMap.first().key)
    br.close()
}
