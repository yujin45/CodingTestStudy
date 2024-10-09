def solution(brown, yellow):
    answer = []
    total_lines = brown + yellow
    
    for height in range(1, int(total_lines ** 0.5)+1):
        # 약수로 확인
        if total_lines % height ==0:
            width = total_lines // height
            if (width-2) * (height -2) == yellow:
                answer =[width , height]
    return answer