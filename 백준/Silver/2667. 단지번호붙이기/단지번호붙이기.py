# 풀이 참고
n = int(input())

graph =[]

for i in range(n):
    graph.append(list(map(int, input().strip())))
    
home = 0 # 방문할 집 수
nums = [] # 단지들 당 집 수

def dfs(x, y):
    global home
    if x < 0 or y<0 or x>=n or y>=n:
        # 범위 밖이면 false
        return False
    if graph[x][y] == 1:
        # 집이 있으면
        home +=1 # 집 1개 증가
        graph[x][y] = 0 # 갔으니까 0으로 바꿔주기
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1) 
        # 상하좌우 재귀로 돌아주기
        return True
    return False # 집 없으면 false

for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            # 집이 있음
            # 재귀 다 돌고 home에 개수 있을 것
            nums.append(home)
            home = 0 # 초기화

nums.sort() # 오름차순 정렬      
print(len(nums))     
for i in nums:
    print(i)    