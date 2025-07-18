def solution(routes):
    # 가장 빨리 나가는 차 기준으로 카메라 설치해야 최대한 많은 차 커버 가능
    
    # 처음 차 진출점에 카메라 설치
    # 다음 차량부터는 
    ## 현재 위치가 그 차량 구간 안이면 pass
    ## 아니면 새로운 카메라 설치
    
    routes.sort(key = lambda x : x[1]) # 진출 지점 기준 정렬
    camera = -30001 # 카메라 초기 위치(최소값보다 작은 값)
    count = 0
    
    for route in routes:
        if camera < route[0]: # 현재 카메라보다 진입 지점이 왼쪽이면
            camera = route[1] # 새 카메라 차량 끝 지점에 설치
            count += 1
    
    return count