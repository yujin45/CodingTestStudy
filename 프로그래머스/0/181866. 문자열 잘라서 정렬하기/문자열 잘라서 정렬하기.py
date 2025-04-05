def solution(myString):
    parts = myString.split("x")
    
    parts = [s for s in parts if s] # 빈 문자열 제거
    
    return sorted(parts)