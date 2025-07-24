def solution(n, times):
    left = 1
    right = n * max(times)
    answer = right
    
    while left <= right:
        mid = (left + right) // 2
        
        total_sum = sum([mid // time for time in times])
        
        if total_sum >= n:
            # 시간 더 줄여도 됨
            answer = mid
            right = mid - 1
        else:
            left = mid + 1
        
    return answer