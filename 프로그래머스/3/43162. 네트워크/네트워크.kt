class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = BooleanArray(n){false}
        var networkCount = 0
        
        fun dfs(node:Int){
            visited[node] = true
            for(i in computers.indices){
                if(computers[node][i] == 1 && !visited[i]){
                    dfs(i)
                }
            }
        }
        
        for(i in 0 until n){
            if(!visited[i]){
                networkCount++
                dfs(i)
            }
        }
        return networkCount
    }
}