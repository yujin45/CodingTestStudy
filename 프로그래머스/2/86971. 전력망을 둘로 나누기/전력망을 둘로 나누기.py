def dfs(graph, v, visited, sub):
    visited[v] = True
    sub[v] = 1
    for neighbor in graph[v]:
        if not visited[neighbor]:
            dfs(graph, neighbor, visited, sub)
            sub[v] += sub[neighbor]

def solution(n, wires):
    
    graph = [[]*(n+1) for _ in range(n+1)]
    visited = [False] * (n+1)
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    sub = [0] * (n+1)
    dfs(graph, 1, visited, sub)
    
    for i in range(1, n+1):
        sub[i] = abs(sub[i] - (n - sub[i]))
    
    return min(sub[1:])