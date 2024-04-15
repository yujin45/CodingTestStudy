def solution(array, commands):
    answer = []
    
    # 인덱스 i-1 : j 로 자르고, 오름차순 정렬, k-1인덱스에 있는 숫자
    for i, j, k in commands:
        answer.append(sorted(array[i-1:j])[k-1])
    
    return answer