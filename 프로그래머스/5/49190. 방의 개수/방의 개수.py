from collections import defaultdict

def solution(arrows):
    direction = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
    direction = [(x*2, y*2) for (x, y) in direction]
    
    # 방문한 정점과 간선 기록
    visited_nodes = set()
    visited_edges = set()
    
    x, y = 0, 0
    visited_nodes.add((x, y))
    count = 0
    
    for d in arrows:
        dx, dy = direction[d]
        
        # 2칸 움직이므로 중간 지점 포함해 2번 이동
        for _ in range(2):
            nx, ny = x + dx // 2, y + dy // 2
            
            # 간선 양 방향으로 저장
            edge = ((x, y), (nx, ny))
            redge = ((nx, ny), (x, y))
            
            # 새 정점인데, 간선도 처음이면 방 생성
            if (nx, ny) in visited_nodes and edge not in visited_edges:
                count += 1
            
            visited_nodes.add((nx, ny))
            visited_edges.add(edge)
            visited_edges.add(redge)
            
            x, y = nx, ny
                
    return count