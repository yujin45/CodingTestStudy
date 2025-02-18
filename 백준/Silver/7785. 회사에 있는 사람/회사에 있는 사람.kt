package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val hashSet = HashSet<String>()
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        if (st.nextToken() == "enter") {
            hashSet.add(name)
        } else {
            hashSet.remove(name) // O(1) 해시 테이블 사용해서
        }
    }
    
    val sortedSet = hashSet.toSortedSet(compareByDescending { it }) // O(N log N), 내부적으로 이진 트리 정렬 수행.
    val sb = StringBuilder()
    sortedSet.forEach { sb.append(it).append("\n") }
    print(sb)
    br.close()
}