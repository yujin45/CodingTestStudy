
fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val people = mutableListOf<Pair<Int, String>>() // 나이 이름
    
    repeat(n) {
        val (age, name) = br.readLine().split(" ")
        people.add(age.toInt() to name)
    }
    
    people.sortWith(compareBy({it.first})) // 나이만 정렬하고 같으면 기존 순서 유지
    
    for((age, name) in people){
        sb.append("$age $name\n")
    }
    print(sb)
}
