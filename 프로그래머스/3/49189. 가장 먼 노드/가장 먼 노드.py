from collections import deque

def bfs(graph, visited, distance):
    queue = deque([1])
    visited[1] = True

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                distance[neighbor] = distance[current] + 1
                queue.append(neighbor)
                
    max_dist = max(distance)
    
    return distance.count(max_dist)

def solution(n, edge):
    graph = [[] for _ in range(n+1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    visited = [False] * (n+1)
    distance = [0] * (n+1)
        
    answer = bfs(graph, visited, distance)

    return answer