
fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val result = mutableListOf<String>()
    val (n, k) = br.readLine().split(" ").map{it.toInt()}
    val people = mutableListOf<Int>()
    repeat(n) {people.add(it+1)}
   
    var index = 0
    sb.append("<")
    while(people.isNotEmpty()){
        index = (index + k - 1) % people.size
        result.add("${people.removeAt(index)}")
    }
    sb.append(result.joinToString(", "))
    sb.append(">")
    print(sb)
}