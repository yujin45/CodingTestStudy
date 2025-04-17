def dfs(numbers, target, index, result):
    count = 0
    if index == len(numbers)-1:
        if result == target:
            return 1
        return 0
        
    count += dfs(numbers, target, index + 1, result +numbers[index+1])
    count += dfs(numbers, target, index+1, result - numbers[index+1])
    return count

def solution(numbers, target):
    answer =dfs(numbers, target, -1, 0)
    
    return answer