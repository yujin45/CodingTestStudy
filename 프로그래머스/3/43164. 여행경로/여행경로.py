from collections import defaultdict

def solution(tickets):
    graph = defaultdict(list)
    
    for a, b in sorted(tickets, reverse = True):
        graph[a].append(b)
    
    route = []
    
    def dfs(curr):
        while graph[curr]:
            # 경로 있는 경우
            next_dest = graph[curr].pop() # 뒤에서부터 
            dfs(next_dest)
        route.append(curr) # 막다른 지점부터 경로에 추가됨
    
    dfs("ICN")
    return route[::-1] # 역순으로 완성되므로 뒤집기