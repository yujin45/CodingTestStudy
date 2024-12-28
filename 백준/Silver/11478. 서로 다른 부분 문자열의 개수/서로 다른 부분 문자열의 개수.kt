fun main() {
    val str = readln() // 입력받은 문자열
    val strSet = HashSet<String>() // 부분 문자열을 저장할 HashSet
    var count = 0 // 부분 문자열의 개수

    // step = substring 시 잘라낼 문자열의 크기
    (1..str.length).forEach { step ->
        // substring 시 인덱스를 초과하지 않게끔 length - step까지만 반복문을 돌린다.
        for (index in 0..str.length - step)
            strSet.add(str.substring(index, index + step))

        count += strSet.size
        strSet.clear()
    }

    println(count)
}