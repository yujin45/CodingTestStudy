def solution(tickets):
    tickets.sort() # 사전 순 정렬
    visited = [False] * len(tickets)
    route = []
    
    def dfs(curr, depth):
        route.append(curr)
        if depth == len(tickets): # 모든 티켓 사용시
            return True
        
        for i, (a, b) in enumerate(tickets):
            if not visited[i] and a == curr:
                visited[i] = True
                if dfs(b, depth+1):
                    return True # 모든 티켓 사용 다 되면 바로 리턴
                visited[i] = False # 백트래킹
        route.pop()
        return False
    
    dfs('ICN', 0)
    return route