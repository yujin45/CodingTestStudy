def solution(nums):
    return min(int(len(nums)/2), len(set(nums)))