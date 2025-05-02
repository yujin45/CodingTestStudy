def dfs(numbers, index, next_num, target):
    count = 0
    if len(numbers) == index:
        if target == next_num:
            return 1
        return 0
    count += dfs(numbers, index+1, next_num + numbers[index], target)
    count += dfs(numbers, index+1, next_num - numbers[index], target)
    return count
    
    
def solution(numbers, target):
    return dfs(numbers, 0, 0, target)