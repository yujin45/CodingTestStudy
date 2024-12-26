
fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val text = br.readLine()

    val result = text.map{char ->
        when{
            char.isUpperCase() -> char.lowercaseChar()
            char.isLowerCase() -> char.uppercaseChar()
            else -> char
        }
    }.joinToString("")
    bw.write("${result}")
    bw.flush()
    br.close()
    bw.close()
}
