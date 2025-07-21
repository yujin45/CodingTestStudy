def solution(routes):
    routes.sort(key = lambda x : x[1]) # 끝점 기준 정렬
    # [ [0, 10], [2, 5], [6, 9] ] 이런 경우 
    
    answer = 1
    now_camera = routes[0][1]
    
    for start, end in routes:
        if start > now_camera:
            # 지금 카메라가 담지 못하는 곳이면
            now_camera = end
            answer += 1
    return answer