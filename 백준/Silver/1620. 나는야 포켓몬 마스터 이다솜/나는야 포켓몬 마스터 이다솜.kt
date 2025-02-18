package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    // 포켓몬 수 n 맞출 m
    val numberName = mutableListOf<String>()
    val nameHashMap = HashMap<String, Int>()
    for (number in 1..N) {
        // 포켓몬 1번 ~ N번까지 들어옴
        val name = br.readLine()
        numberName.add(name)
        nameHashMap[name] = number
    }
    repeat(M) {
        val userInput = br.readLine()
        if (userInput[0].isDigit()) { // 첫번째 글자만 숫자인지 판단해줘도 됨
            sb.append(numberName[userInput.toInt() - 1]).append("\n")
        } else {
            sb.append(nameHashMap.getValue(userInput)).append("\n")
        }
    }
    print(sb)
    br.close()
}