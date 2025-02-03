package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    var count = 0

    repeat(N) {
        val word = br.readLine()
        val seen = BooleanArray(26) // 알파벳 26개
        var isGroupWord = true

        for (i in word.indices) {
            if (i > 0 && word[i] != word[i - 1] && seen[word[i] - 'a']) {
                // 2번째 알파벳이 이전과 다른데, 이미 seen에 존재하면 그룹 단어 아님
                isGroupWord = false
                break
            }
            // 위에 해당하는게 아니면 단어 등장 표시하기
            seen[word[i] - 'a'] = true
        }
        if (isGroupWord) count++
    }

    println(count)
    br.close()
}
