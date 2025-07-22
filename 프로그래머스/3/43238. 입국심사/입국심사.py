def solution(n, times):
    left = 1
    right = n * max(times) # O(N)
    minimum_time = right
    
    while left <= right:
        mid = (left + right) // 2
        
        able_n = sum([mid // time for time in times])

        if able_n >= n:
            minimum_time = mid
            right = mid - 1
        else:
            left = mid + 1    
    
    return minimum_time