import sys

input = sys.stdin.readline
#
X = int(input())
print(bin(X).count('1'))