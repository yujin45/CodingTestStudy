import sys

input = sys.stdin.readline

##########
n, m = map(int, input().split())
# 1~n까지 자연수 중 중복 없이 m개 고른 수열

sequence = [0] * n
visited = [False] *n
result = []
arr = [i for i in range(1, n+1)]
def permutations(k, arr, sequence, visited, result, depth):
    if depth == k:
        result.append(sequence[:k].copy())
        return
    for i in range(len(arr)):
        if not visited[i]:
            visited[i] = True
            sequence[depth] = arr[i]
            permutations(k, arr, sequence, visited, result, depth+1)
            visited[i] = False

permutations(m, arr, sequence, visited, result, 0)
for r in result:
    print(' '.join(map(str, r)))