fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val s = br.readLine()
    val n = s.length
    val hashSet = hashSetOf<String>()
    var ret = 0
    // STEP별로 잘라내기
    for(step in 1..n){
        // step = 1 ~ n개로 문자열 잘라내기
        for(j in 0..n-step){
            hashSet.add(s.substring(j, j+step))
        }
        // step에 해당하는 것 다 돌아서 다음 step 가기 전 횟수 저장 및 초기화
        ret += hashSet.size
        hashSet.clear()
    }
    bw.write("$ret\n")

    bw.flush()
    br.close()
    bw.close()

}