def solution(n, results):
    # A < B < C 이 경우 A < C가 성립
    # A < B , B < C일 경우 A < C
    graph = [[0]*(n+1) for _ in range(n+1)] # 1~n번 선수
    
    for a, b in results:
        graph[a][b] = 1 # 이긴 표시
        graph[b][a] = -1 # 진 표시
    
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                if graph[i][k] == 1 and graph[k][j] == 1:
                    # i가 k를 이겼고 k가 j를 이긴 경우 => i가 j를 이긴다. 
                    graph[i][j] = 1
                    graph[j][i] = -1
                elif graph[i][k] == -1 and graph[k][j] == -1:
                    # i가 k에게 지고 k가 j에게 진다. => i가 j에게 진다. 
                    graph[i][j] = -1
                    graph[j][i] = 1
    answer = 0
    for i in range(1, n+1):
        count = 0
        for j in range(1, n+1):
            if i != j and graph[i][j] != 0:
                count += 1
        if count == n-1:
            answer += 1
    
    
    return answer