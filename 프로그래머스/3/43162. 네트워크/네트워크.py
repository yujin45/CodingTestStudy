def dfs(computers, v, visited, n):
    visited[v] = 1
    
    for i in range(n):
        if computers[v][i] and not visited[i]:
            # 노드 있고 방문 전이면
            dfs(computers, i, visited, n)
            
def solution(n, computers):
    answer = 0
    
    visited = [0 for _ in range(n)]

    for i in range(n):
        if not visited[i]:
            dfs(computers, i, visited, n)
            answer+=1
            
    return answer

