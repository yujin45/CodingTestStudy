import sys

input = sys.stdin.readline


def fib(num):
    # if num == 0:
    #     return 0
    # if num == 1:
    #     return 1
    if num <2:
        return num
    return fib(num - 1) + fib(num - 2)


num = int(input())
print(fib(num))
