package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    var before: Char
    var notGroupflag = false
    var count = 0
    repeat(N) {
        val alphabet = br.readLine()
        val alphabetSet = HashSet<Char>()

        before = alphabet[0]
        alphabetSet.add(alphabet[0])
        for (i in 1 until alphabet.length) {
            if (alphabet[i] != before) {
                // 이전과 다르면 set에 있는지 일단 확인
                if (alphabet[i] in alphabetSet) {
                    // 있는 경우 검사 더 필요 없음
                    notGroupflag = true
                    break
                } else {
                    // 없는 경우
                    alphabetSet.add(alphabet[i])
                }
                before = alphabet[i]
            }
        }
        if (!notGroupflag) {
            count++
        } else {
            notGroupflag = false
        }
    }
    println(count)
    br.close()
}
