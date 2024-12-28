fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val inp = br.readLine()
    val arr = mutableListOf<String>()

    for (start in 0..inp.length) {
        for (end in start + 1..inp.length) {
            arr.add(inp.substring(start, end))
        }
    }
    bw.write(arr.distinct().size.toString())
    bw.flush()
    bw.close()
}