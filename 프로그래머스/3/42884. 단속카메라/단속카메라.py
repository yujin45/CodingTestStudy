def solution(routes):
    routes.sort(key = lambda x : x[1]) # 종료 시간이 빠른 순으로 정렬
    curr_camera = -30_000 # 조건에서 주어진 값
    answer = 0
    
    for start, end in routes:
        if start > curr_camera:
            # 시작 지점이 지금 담을 수 없다면
            curr_camera = end
            answer += 1
    
    
    return answer