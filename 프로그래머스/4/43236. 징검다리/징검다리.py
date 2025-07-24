def solution(distance, rocks, n):
    rocks.sort()
    if rocks[-1] != distance:
        rocks.append(distance)
    
    left = 1
    right = distance
    answer = right
    
    while left <= right:
        mid = (left + right) // 2
        
        remove_count = 0
        prev = 0
        for rock in rocks:
            if rock - prev < mid: # ★ mid가 현재 최소여서, mid보다 작으면 제거
                remove_count += 1
            else:
                prev = rock
        
        # mid일 때 n개 이하 제거이면 더 늘려봐도 됨
        if remove_count <= n:
            answer = mid
            left = mid + 1
        else:
            # 너무 많이 제거되었으면 좀 줄여야 함
            right = mid - 1
            
    return answer