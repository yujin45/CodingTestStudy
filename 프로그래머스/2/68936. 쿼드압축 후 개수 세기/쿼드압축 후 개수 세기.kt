
class Solution {

    private var oneCount = 0
    private var zeroCount = 0

    fun solution(arr: Array<IntArray>): IntArray {
        dfs(arr, 0, 0, arr.size)
        return intArrayOf(zeroCount,oneCount)
    }

    private fun isAllSame(graph:Array<IntArray>, sx:Int, sy:Int, size:Int):Boolean{
        val num = graph[sx][sy]
        for(i in sx until sx+size){
            for(j in sy until sy+size){
                if(graph[i][j]!=num){
                    return false
                }
            }
        }
        return true
    }
    fun dfs(graph: Array<IntArray>, sx: Int, sy: Int,size: Int) {
        if(isAllSame(graph, sx, sy, size)){
            if(graph[sx][sy] ==1){
                oneCount++
            }else{
                zeroCount++
            }
            // 다 같은거면 dfs 종료
            return
        }

        val half = size/2 
        dfs(graph, sx, sy, half) // 왼쪽 위 
        dfs(graph, sx, sy+half, half) //  오른쪽 위
        dfs(graph, sx+half, sy, half) // 왼쪽 아래
        dfs(graph, sx+half, sy+half, half) // 오른쪽 아래
    }
}

