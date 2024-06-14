def solution(num, total):
    # 첫 번째 수 x 계산
    x = (total - (num * (num - 1)) // 2) // num
    
    # 연속된 num개의 정수를 리스트로 반환
    return [x + i for i in range(num)]
    
    return answer