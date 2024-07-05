class Solution {
    fun solution(todo_list: Array<String>, finished: BooleanArray): Array<String> {
        // 마치치 못한 일들만 담기
        return todo_list.filterIndexed{ index, _ -> !finished[index]}.toTypedArray()
        
    }
}