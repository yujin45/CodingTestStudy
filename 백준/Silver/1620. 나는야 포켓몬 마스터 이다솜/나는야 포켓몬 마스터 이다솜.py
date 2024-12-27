import sys
input = sys.stdin.readline


N, M = map(int, input().split())

my_dict = dict()

for i in range(1, N+1):
    name = input().strip()
    # 이름과 번호를 하나의 dict에서 다 관리
    my_dict[str(i)] = name
    my_dict[name] = str(i)

print('\n'.join([my_dict[input().strip()] for _ in range(M)]))