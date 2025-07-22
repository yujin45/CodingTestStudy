from collections import deque

def solution(n, edge):
    graph = [[] for _ in range(n+1)] # 1부터 n까지
    
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    # 각각 1로부터 얼만큼 떨어져 있는지 확인 필요
    visited = [False] * (n+1)
    queue = deque([1]) # 1에서 시작
    visited[1] = True
    distance = [0] * (n+1)
    while queue:
        curr = queue.popleft()
        for neighbor in graph[curr]:
            if not visited[neighbor]:
                queue.append(neighbor)
                visited[neighbor] = True
                distance[neighbor] = distance[curr] + 1 # 부모보다 1 증가

    max_value = max(distance)
    answer = distance.count(max_value)
    return answer