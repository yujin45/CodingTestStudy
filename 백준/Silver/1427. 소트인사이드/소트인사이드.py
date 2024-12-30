import sys

input = sys.stdin.readline

nums = list(input().strip())
nums.sort(reverse = True)
print(''.join(nums))