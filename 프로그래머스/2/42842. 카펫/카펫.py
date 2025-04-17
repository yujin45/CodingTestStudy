def solution(brown, yellow):
    answer = []
    total_lines = brown + yellow
    
    for h in range(1, int(total_lines**0.5) + 1):
        if total_lines % h == 0:
            # h로 나눠지면 w를 확인
            w = total_lines // h
            if (w-2) * (h-2) == yellow:
                answer = [w, h]
    return answer