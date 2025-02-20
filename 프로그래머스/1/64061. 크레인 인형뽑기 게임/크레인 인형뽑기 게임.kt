class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var count = 0
        //  만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다. 
        val backet = mutableListOf<Int>() // 바구니 
        //printBoard(board)

        // moves에 담긴 i번 위치 ->인덱스로 i-1 위치

        // board를 어떻게 다룰까
        // 1. n개의 스택으로 만들어두고 쓴다 => 뽑는 것은 쉽겠지만 공간 낭비 => PASS
        // 2. 행 0부터 ->N-1까지 0이 아닌 순간을 찾는다 => 최악 O(N) => moves의 수가 K라면  O(K*N) -> 1000 X 100 = 100_000
        // 3. 열의 개수만큼 가장 상단 인덱스를 저장하는 배열을 만든다 
        //     => 메모리 좀 차지하겠지만 처음 초기화 최악 O(N^2) 이후로는 탐색 O(1) -> 10_000

        // 일단 3번으로 풀고 저거 시간복잡도 맞는지 GPT에게 물어보자
        val topIndex = IntArray(board.size)
        for(col in board.indices){
            for(row in board.indices){
                if(board[row][col] !=0){
                    topIndex[col] = row
                    break
                }
            }
        }
        //println("topIndex: ${topIndex.contentToString()}")

        for(m in moves){
            val col = m-1
            val row = topIndex[col]

            if(row < board.size){
                val doll = board[row][col]
                if(backet.isNotEmpty() &&backet.last() == doll){
                    // 맨 위가 doll이랑 같으면
                    backet.removeLast() // 뽑아버리기
                    count+=2
                }else{
                    // 위의 조건 아니면 그냥 다 넣기
                    backet.add(doll)
                }
                board[row][col] = 0 // 인형 뽑기 완료
                topIndex[col]++ // 인형 뽑아서 한칸 내려감
            }
            // 만약 인형 없으면 아무 일도 일어나지 않음
        }


        return count
    }

    // fun printBoard(board:Array<IntArray>){
    //     board.forEach{ println(it.contentToString())}
    // }
}