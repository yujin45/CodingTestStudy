class Solution {
    fun solution(todo_list: Array<String>, finished: BooleanArray): Array<String> {
        return todo_list.filterIndexed{i, v -> finished[i].not()}.toTypedArray()
    }
}