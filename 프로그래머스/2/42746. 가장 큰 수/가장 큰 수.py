def solution(numbers):
    numbers = list(map(str, numbers)) 
    # 3번 반복하게 된다면 (1000이하라서 3번 반복)
    # 333, 303030 이렇게 확장되고 문자열 기준 333이 더 크다고 판별
    sorted_numbers = sorted(numbers, key = lambda x: x*3, reverse = True) 
    result = ''.join(sorted_numbers)
    return '0' if result[0] =='0' else result