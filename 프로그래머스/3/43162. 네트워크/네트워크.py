def solution(n, computers):
    visited = [False] * n
    
    def dfs(node):
        visited[node] = True
        for j in range(n):
            if computers[node][j] == 1 and not visited[j]:
                # node와 연결된 모든 j노드를 방문처리
                dfs(j)
    
    answer = 0
    for i in range(n):
        if not visited[i]:
            dfs(i) # 새로운 네트워크 시작
            answer += 1
            
    return answer