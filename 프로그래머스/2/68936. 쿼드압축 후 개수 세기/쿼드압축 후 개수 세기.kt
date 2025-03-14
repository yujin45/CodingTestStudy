class Solution {
    fun solution(arr: Array<IntArray>): IntArray {

        // 0개수 1 개수
        val n = arr.size
        val (z, o) = dfs(arr, 0, 0, n)
        var answer: IntArray = intArrayOf(z, o)

        return answer
    }

    fun dfs(graph:Array<IntArray>, start:Int, end:Int, n:Int): Pair<Int, Int>{
        //println("---------------dfs")
        //println("$start, $end - $n")
        var zero = 0
        var one = 0
        val initElement = graph[start][end]
        var isSame = true

        for(i in start until start+n){
            if(!isSame) break
            for(j in end until end+n){
                if(graph[i][j] != initElement){
                    // 같이 않으면 바로 멈추기
                    //println("동일하지 않은 것 발견 - i $i, j $j - ${graph[i][j]} != $initElement")
                    isSame = false
                    break
                }
            }
        }

        if(!isSame){
            // 4분할 진행
            //println("00000000000000000000000000 4분할 진행!")
            val (z1, o1) = dfs(graph, start, end, n/2)
            val (z2, o2) = dfs(graph, start+n/2, end, n/2)
            val (z3, o3) = dfs(graph, start, end+n/2, n/2)
            val (z4, o4) = dfs(graph, start+n/2, end+n/2, n/2)
            zero = z1 + z2 + z3 + z4
            one = o1 + o2 + o3 + o4
        }else{
            // 모든 값이 같으면
            if(initElement  == 0){
                // 0
                zero = 1
            }else{
                // 1
                one = 1
            }
        }
        //println("\n\n 결과 $start, $end - $n - $zero $one \n")
        return (zero to one)

    }
}