def solution(array, n):
    sorted_array = sorted(array)
    diff = []
    for a in sorted_array:
        diff.append(abs(a-n))
    min_diff = min(diff)
    return sorted_array[diff.index(min_diff)]