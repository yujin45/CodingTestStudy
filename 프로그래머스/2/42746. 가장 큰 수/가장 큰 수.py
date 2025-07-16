from functools import cmp_to_key

def compare(a, b):
    if a + b > b + a:
        return -1
    elif b + a > a + b:
        return 1
    else:
        return 0

def solution(numbers):
    str_nums = sorted(list(map(str, numbers)), key = cmp_to_key(compare))
    ret = ''.join(str_nums)
    return '0' if ret.startswith('0') else ret