from collections import defaultdict

def solution(tickets):
    # 그래프 생성 및 도착지를 내림차순으로 정렬
    routes = defaultdict(list)
    #print(routes)
    for start, end in tickets:
        routes[start].append(end)
    for start in routes:
        routes[start].sort(reverse=True)
    #print(routes)

    # DFS 탐색
    stack = ["ICN"]  # 시작 공항
    path = []  # 방문한 경로를 저장할 리스트

    while stack:
        current = stack[-1]
        #print("current : "+ (current) +" / stack: "+ str(stack))
        # 현재 공항에서 더 갈 곳이 없으면 경로에 추가
        if not routes[current]:
            #print("없다 "+ current)
            path.append(stack.pop())
        else:
            # 더 갈 곳이 있다면 스택에 추가하고 경로에서 제거
            stack.append(routes[current].pop())
        # print("stack : "+str(stack))
        # print("path : "+str(path))
        # print("route : "+str(routes))

    # 역순으로 경로를 반환
    return path[::-1]
