from collections import defaultdict
# 방이 되는 기준 -> 이미 지나왔던 경로를 다시 지나갈 때 
# 이때 a-> b 이후 다시 b -> a로 가는 경우는 a가 다시 겹치지만 방이 생성되지 않음
# 그러므로 시작점과 도착점을 함께 봐야 함
# 그리고 대각선 교차를 측정하기 위해서는 좌표값을 2배로 해야 가능

def solution(arrows):
    # 일반 좌표계 기준으로 방향 설정 0 ~ 7
    direct = [[0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1], [-1, 0], [-1, 1]]
    visited = defaultdict(set)
    x, y = 0, 0
    room = 0
    
    for d in arrows:
        for _ in range(2): # 2배 좌표계 확장 대각선 교차도 확인해야 해서
            dx, dy = direct[d]
            nx, ny = x + dx, y + dy
            
            if (nx, ny) in visited and (x, y) not in visited[(nx, ny)]:
                room += 1 # 이전 nx, ny 방문한 적은 있지만 그게 x, y에서 온 것이 아니면 방 생성
            
            visited[(x, y)].add((nx, ny))
            visited[(nx, ny)].add((x, y))
            x, y = nx, ny
    
    return room