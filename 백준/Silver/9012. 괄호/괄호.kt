

import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    for (i in 0 until n) {
        val ps = br.readLine()
        val stack = Stack<Char>()  // Stack으로 변경

        var isVPS = true
        for (c in ps) {
            if (c == '(') {
                stack.push(c)  // addLast → push
            } else if (c == ')') {
                if (stack.isEmpty()) {  // isEmpty 동일
                    isVPS = false
                    break
                }
                stack.pop()  // removeLast → pop
            }
        }

        if (isVPS && stack.isEmpty()) {
            sb.append("YES\n")
        } else {
            sb.append("NO\n")
        }
    }
    print(sb)
}
