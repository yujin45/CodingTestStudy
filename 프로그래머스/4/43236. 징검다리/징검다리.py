def solution(distance, rocks, n):
    rocks.sort()
    if rocks[-1] != distance:
        rocks.append(distance)
    
    left = 1
    right = distance
    answer = 0
    
    while left <= right:
        mid = (left + right) // 2
        prev = 0
        remove_count = 0
        
        for rock in rocks:
            if rock - prev < mid:
                remove_count += 1 # 바위 제거
            else:
                prev = rock # 바위 유지 
        
        if remove_count > n:
            right = mid - 1 # 너무 많이 제거해야 하니 거리 줄여야 함
        else:
            answer = mid # 이 거리 가능, 더 키울 수도 있음
            left = mid + 1
    
    return answer