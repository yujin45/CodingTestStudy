from collections import defaultdict

def solution(tickets):
    graph = defaultdict(list)
    
    # 그래프 구성 + 정렬
    for start, end in tickets:
        graph[start].append(end)
    
    for key in graph:
        graph[key].sort(reverse = True) # 나중에 pop() 쓰려고 reverse
    
    route = []
    
    def dfs(curr):
        
        while graph[curr]:
            next = graph[curr].pop()
            #print(curr, next)
            dfs(next)
        route.append(curr) # 더이상 진행할 곳이 없으면 넣기
        #print("넣음 - "+ curr)
    
    dfs("ICN")
    
    return route[::-1] # 역순으로 뒤집기