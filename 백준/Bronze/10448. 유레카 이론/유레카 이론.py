def is_eureka_number(k, triangle_numbers):
    # 3중 루프를 사용해 K를 검사
    for i in triangle_numbers:
        for j in triangle_numbers:
            for h in triangle_numbers:
                if i + j + h == k:
                    return 1
    return 0

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    T = int(data[0])  # 테스트케이스 개수
    cases = list(map(int, data[1:]))
    
    # 삼각수 리스트 생성 (Tn ≤ 1000)
    triangle_numbers = []
    n = 1
    while True:
        t = n * (n + 1) // 2  # 삼각수 계산
        if t > 1000:  # 1000을 초과하면 종료
            break
        triangle_numbers.append(t)
        n += 1
    
    # 각 테스트케이스 처리
    results = []
    for k in cases:
        results.append(is_eureka_number(k, triangle_numbers))
    
    # 결과 출력
    sys.stdout.write('\n'.join(map(str, results)) + '\n')

if __name__ == "__main__":
    main()
