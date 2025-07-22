def solution(distance, rocks, n):
    rocks.sort()
    if rocks[-1] != distance:
        rocks.append(distance)
    
    left = 1
    right = distance
    answer = right
    
    while left <= right:
        mid = (left + right) // 2 # 거리의 최솟값
        
        remove_count = 0
        prev = 0
        for rock in rocks:
            if rock - prev < mid:
                # 최소거리 mid보다 작으면 제거
                remove_count += 1
            else:
                prev = rock
        if remove_count > n:
            # 너무 많이 제거해야 한다면 최소 거리 줄이기
            right = mid - 1
        else:
            # n개 이하로 제거했다면 최소 거리를 늘릴 수 있음
            answer = mid
            left = mid + 1
        
    
    return answer 