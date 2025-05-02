from collections import deque

def solution(n, edge):
    graph = [[] for _ in range(n+1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
        
    visited = [False] * (n+1)
    distance = [0] * (n+1)
    
    queue = deque([1])
    visited[1] = True
    
    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                queue.append(neighbor)
                visited[neighbor] = True
                distance[neighbor] = distance[current] + 1
    
    max_value = max(distance)
    return distance.count(max_value)