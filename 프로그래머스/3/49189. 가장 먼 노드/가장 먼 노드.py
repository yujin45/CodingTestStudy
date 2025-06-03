from collections import deque

def solution(n, edge):
    
    graph = [[] for _ in range(n+1)] # 0번은 제외
    
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    distance = [0] * (n+1)
    
    queue = deque([1])
    
    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if distance[neighbor] == 0:
                queue.append(neighbor)
                distance[neighbor] = distance[current] + 1
                
    distance = distance[2:]
    max_val = max(distance)
    
    return distance.count(max_val)