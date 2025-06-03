
def solution(n, times):
    times.sort()
    
    left = 1
    right = times[-1] * n
    answer = right # 최댓값에서 시작
    
    while left <= right:
        mid = (left + right) // 2
        done = sum([mid // time for time in times])
        if done >= n:
            answer = mid # 현재 가능하므로 두고
            right = mid - 1 # 더 짧은 왼쪽 시도
        elif done < n:
            left = mid + 1 #오른 쪽 시도
        
    return answer