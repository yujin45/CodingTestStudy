fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    // 숫자의 최대값
    val MAX_VALUE = 10000

    // 숫자 등장 횟수를 기록하는 배열
    val count = IntArray(MAX_VALUE + 1)

    // 첫 번째 줄: 숫자의 개수
    val n = br.readLine().toInt()

    // 숫자 입력 처리
    repeat(n) {
        val num = br.readLine().toInt()
        count[num]++
    }

    // 정렬된 결과 출력
    for (i in 1..MAX_VALUE) {
        if (count[i] > 0) {
            repeat(count[i]) {
                bw.write("$i\n")
            }
        }
    }

    bw.flush()
    br.close()
    bw.close()
}