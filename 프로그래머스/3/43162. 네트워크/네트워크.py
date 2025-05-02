def dfs(graph, v, visited):
    visited[v] = True
    
    for i in range(len(graph)):
        if graph[v][i] == 1 and not visited[i]:
            dfs(graph, i, visited)
            
    
def solution(n, computers):
    count = 0
    visited = [False] * (n+1)
    
    for i in range(n):
        if not visited[i]:
            dfs(computers, i, visited)
            count+=1
            
    return count