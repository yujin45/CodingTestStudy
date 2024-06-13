def solution(s1, s2):
    # 중복이 없다는 것에 포인트 => set
    
    return len(set(s1) & set(s2))