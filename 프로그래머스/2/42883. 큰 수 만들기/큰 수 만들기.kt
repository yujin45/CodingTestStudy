class Solution {
    fun solution(number: String, k: Int): String {
        val stack = StringBuilder()
        var removeCount = k

        for (digit in number) {
            // 현재 숫자가 스택의 마지막 숫자보다 크면 제거 (k번만큼)
            while (stack.isNotEmpty() && removeCount > 0 && stack.last() < digit) {
                stack.deleteCharAt(stack.length - 1)
                removeCount--
            }
            stack.append(digit)
        }

        // 아직 제거해야 할 숫자가 남아 있다면, 뒤에서 k개를 자른다.
        return stack.substring(0, stack.length - removeCount)

    }
}