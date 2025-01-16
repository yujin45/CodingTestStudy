import sys
sys.setrecursionlimit(1000010)

def dfs(r, c, l, m, n, vis):
    if r == m - 1:
        return "YES"
    
    vis[r][c] = 1

    dr = [1, 0, -1, 0]
    dc = [0, 1, 0, -1]

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if (0 <= nr < m and 0 <= nc < n and 
            l[nr][nc] == '0' and not vis[nr][nc]):
            if dfs(nr, nc, l, m, n, vis) == "YES":
                return "YES"
    
    return "NO"

def main():
    m, n = map(int, input().split())
    l = [input() for _ in range(m)]
    vis = [[0] * n for _ in range(m)]
    for j in range(n):
        if l[0][j] == '0' and not vis[0][j]:
            if dfs(0, j, l, m, n, vis) == "YES":
                print("YES")
                exit(0)
    print("NO")
    
if __name__ == '__main__':
    main()