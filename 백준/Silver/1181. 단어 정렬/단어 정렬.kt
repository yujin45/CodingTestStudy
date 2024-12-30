fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val vocaSet = mutableSetOf<String>()
    
    repeat(n){
        vocaSet.add(br.readLine())
    }
    
    val sortedList = vocaSet.toList().sortedWith(compareBy({it.length}, {it}))
    
    sortedList.forEach{println(it)}
}