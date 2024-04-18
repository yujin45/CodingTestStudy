n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input().strip())))

home = 0
nums = []
def dfs(x, y):
    global home
    if x <0 or y <0 or x>=n or y>=n:
        return False

    if graph[x][y]==1:
        home +=1
        graph[x][y]=0
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True

    return False

for i in range(n):
    for j in range(n):
        if dfs(i, j)==True:
            nums.append(home)
            home = 0
nums.sort()
print(len(nums))
for i in nums:
    print(i)