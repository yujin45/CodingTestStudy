import sys

input = sys.stdin.readline

n = 1

t = int(input().strip())

ret = 0
nums = []
while True:
    ret = n * (n + 1) // 2
    if ret > 1000:
        break

    nums.append(ret)
    n += 1


def check(k):
    for i in range(len(nums)):
        for j in range(len(nums)):
            for h in range(len(nums)):
                ksum = nums[i] + nums[j] + nums[h]
                if ksum == k:
                    return 1

    return 0


for _ in range(t):
    k = int(input().strip())
    print(check(k))
