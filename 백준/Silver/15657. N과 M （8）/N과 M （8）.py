import sys

input = sys.stdin.readline

########## 입력
n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
########### 코드
k = m
sequence = [0] * n
visited = [False] * n
result = []
#arr = [i for i in range(1, n + 1)]
######################################################
# 1~n까지 자연수 중 중복 없이 m개 고른 수열 - 순열
def permutations(depth):
    global k, arr, sequence, visited, result
    if depth == k:
        result.append(sequence[:k].copy())
        return
    for i in range(len(arr)):
        if not visited[i]:
            visited[i] = True
            sequence[depth] = arr[i]
            permutations(depth + 1)
            visited[i] = False


#permutations(0)

# 1~N까지 자연수 중 중복 없이 M개 고르기 - 조합
def combinations(depth, start):
    global k, arr, sequence, visited, result
    if depth == k:
        result.append(sequence[:k].copy())
        return
    for i in range(start, len(arr)):
        if not visited[i]:
            visited[i] = True
            sequence[depth] = arr[i]
            combinations(depth + 1, i + 1)  # 여기 i+1을 줘서 지금보다 뒤에 있는 것들 들어가게 해야 함
            visited[i] = False


#combinations(0, 0)

# # 1~n까지 자연수 중 중복 O m개 고른 수열, 같은 수를 여러 번 골라도 된다. - product 중복순열
def product(depth):
    global k, arr, sequence, result
    if depth == k:
        result.append(sequence[:k].copy())
        return
    for i in range(len(arr)):
        sequence[depth] = arr[i]
        product(depth + 1)


#product(0)

# 1~N까지 자연수 중 중복  O m개 고른 수열, 같은 수를 여러 번 골라도 된다. - combinations_with_replacement 중복조합
def combinations_with_replacement(depth, start):
    global k, arr, sequence, result
    if depth == k:
        result.append(sequence[:k].copy())
        return
    for i in range(start, len(arr)):
        sequence[depth] = arr[i]
        combinations_with_replacement(depth + 1, i)  # 여기 i+1을 줘서 지금보다 뒤에 있는 것들 들어가게 해야 함


combinations_with_replacement(0, 0)


############ 출력
for r in result:
    print(' '.join(map(str, r)))
