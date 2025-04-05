from collections import deque

def bfs(graph, v, distance):
    queue = deque()
    queue.append(v)
    
    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if distance[neighbor] == -1: # 아직 방문 안한 노드
                distance[neighbor] = distance[current] + 1 # 현재에서 +1
                queue.append(neighbor)

                
def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    distance = [-1] * (n+1)
    distance[1] = 0 # 1번 노드 거리는 0
    
    bfs(graph, 1, distance)
    
    max_dist = max(distance) 
    return distance.count(max_dist)