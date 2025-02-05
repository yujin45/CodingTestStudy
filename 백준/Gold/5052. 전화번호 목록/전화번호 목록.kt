package org.example

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    // 일관성 유지 조건: 한 번호갇 ㅏ른 번호의 접두어인 경우 x
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        // 일단 번호를 다 받고 정렬해야 할 것 같음
        // 1 12 123 124 이렇게 해두고
        val phoneNumbers = Array(n) {
            br.readLine()
        }.sorted()

        var isConsistent = true
        //- 전화번호를 정렬하면 한 번호의 접두어가 될 수 있는 번호는 바로 다음 번호뿐
        //- 따라서 연속한 두 개의 번호만 비교
        for (i in 0 until phoneNumbers.size - 1) {
            if (phoneNumbers[i + 1].startsWith(phoneNumbers[i])) {
                isConsistent = false
                break
            }
        }
        if (isConsistent) {
            sb.append("YES\n")
        } else {
            sb.append("NO\n")
        }
    }
    print(sb)
    br.close()
}