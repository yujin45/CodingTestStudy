
fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    var stack = mutableListOf<Char>()
    for(i in 0 until n) {
        val ps = br.readLine()

        for(c in ps){
            if (c == '('){
                stack.add(c)
            }else if(c==')'){
                if(stack.isEmpty()){
                    stack.add(c)
                    break
                }
                stack.removeLast()
            }
        }

        if(stack.isNotEmpty()){
            sb.append("NO\n")
            stack.clear()
        }else {
            sb.append("YES\n")
        }
    }
    print(sb)
}
