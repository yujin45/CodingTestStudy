import sys

input = sys.stdin.readline

n = int(input())
n_set = set(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))

ret = []
for m in m_list:
    if m in n_set:
        ret.append("1")
    else:
        ret.append("0")

print('\n'.join(ret))