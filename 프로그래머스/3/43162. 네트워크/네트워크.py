def dfs(computers, visited, com):
    visited[com] = True
    for i in range(len(computers)):
        if computers[com][i] == 1 and not visited[i]:
            dfs(computers, visited, i)
            
def solution(n, computers):
    visited = [False] * n
    network = 0
    for com in range(n):
        if not visited[com]:
            dfs(computers, visited, com)
            network += 1
    return network